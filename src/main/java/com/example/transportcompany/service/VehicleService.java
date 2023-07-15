package com.example.transportcompany.service;

import com.example.transportcompany.dto.VehicleDto;
import com.example.transportcompany.dto.VehicleFilterDto;
import com.example.transportcompany.model.Vehicle;
import com.example.transportcompany.repository.VehicleRepository;
import com.example.transportcompany.util.MappingUtils;
import com.example.transportcompany.util.exceptions.InvalidRequestException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> filter(VehicleFilterDto filter) {
        Optional<String> brandOptional = filter.getBrand();
        Optional<String> modelOptional = filter.getModel();
        Optional<String> categoryOptional = filter.getCategory();
        Optional<String> typeOptional = filter.getType();
        Optional<Integer> releaseYearOptional = filter.getReleaseYear();
        Optional<Boolean> hasTrailerOptional = filter.getHasTrailer();

        String queryString = "SELECT V FROM Vehicle V JOIN VehicleCategory C ON (V.category.id = C.id) " + "JOIN VehicleType T ON (V.category.id = T.id)";
        List<String> whereParams = new ArrayList<>();

        brandOptional.ifPresent(s -> whereParams.add("V.brand = '" + s + "'"));
        modelOptional.ifPresent(s -> whereParams.add("V.model = '" + s + "'"));
        categoryOptional.ifPresent(s -> whereParams.add("C.categoryName = '" + s + "'"));
        typeOptional.ifPresent(s -> whereParams.add("T.typeName = '" + s + "'"));
        releaseYearOptional.ifPresent(integer -> whereParams.add("V.releaseYear = " + integer));
        hasTrailerOptional.ifPresent(aBoolean -> whereParams.add("V.hasTrailer = " + aBoolean));

        if (!whereParams.isEmpty()) queryString += " WHERE " + String.join(" AND ", whereParams);

        TypedQuery<Vehicle> vehicleQuery = entityManager.createQuery(queryString, Vehicle.class);

        return vehicleQuery.getResultList();
    }

    public void editVehicle(VehicleDto vehicleDto) {
        final long id = vehicleDto.getId();

        Optional<Vehicle> vehicleOptionalById = vehicleRepository.findById(id);
        Optional<Vehicle> vehicleOptionalByStateNumber = vehicleRepository.findVehicleByStateNumber(vehicleDto.getStateNumber());

        if (vehicleOptionalById.isPresent() && (vehicleOptionalByStateNumber.isEmpty() || id == vehicleOptionalByStateNumber.get().getId())) {
            vehicleRepository.save(MappingUtils.mapToVehicle(vehicleDto));
        } else {
            throw new InvalidRequestException("Invalid data");
        }
    }

    public void addVehicle(VehicleDto vehicleDto) {
        Optional<Vehicle> vehicleOptionalByStateNumber = vehicleRepository.findVehicleByStateNumber(vehicleDto.getStateNumber());

        if (vehicleOptionalByStateNumber.isPresent())
            throw new InvalidRequestException("This stateNumber is already exists");

        vehicleDto.setId(null);

        Vehicle vehicle = MappingUtils.mapToVehicle(vehicleDto);

        vehicleRepository.save(vehicle);
    }
}
