package com.example.transportcompany.service;

import com.example.transportcompany.dto.VehicleFilterDto;
import com.example.transportcompany.model.Vehicle;
import com.example.transportcompany.repository.VehicleRepository;
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
        Optional<Boolean> hasTrailerOptional = filter.getHasTrailer();

        String queryString = "SELECT V FROM Vehicle V JOIN VehicleCategory C ON (V.category.id = C.id) " +
                             "JOIN VehicleType T ON (V.category.id = T.id)";
        List<String> whereParams = new ArrayList<>();

        if (brandOptional.isPresent()) whereParams.add("V.brand = '" + brandOptional.get() + "'");
        if (modelOptional.isPresent()) whereParams.add("V.model = '" + modelOptional.get() + "'");
        if (categoryOptional.isPresent()) whereParams.add("C.categoryName = '" + categoryOptional.get() + "'");
        if (typeOptional.isPresent()) whereParams.add("T.typeName = '" + typeOptional.get() + "'");
        if (hasTrailerOptional.isPresent()) whereParams.add("V.hasTrailer = " + hasTrailerOptional.get());

        if (whereParams.isEmpty() == false) queryString += " WHERE " + String.join(" AND ", whereParams);

        TypedQuery<Vehicle> vehicleQuery = entityManager.createQuery(queryString, Vehicle.class);

        return vehicleQuery.getResultList();
    }
}
