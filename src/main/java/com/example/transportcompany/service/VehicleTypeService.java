package com.example.transportcompany.service;

import com.example.transportcompany.model.VehicleType;
import com.example.transportcompany.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {
    private final VehicleTypeRepository typeRepository;

    @Autowired
    public VehicleTypeService(VehicleTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<VehicleType> findAll() {
        return typeRepository.findAll();
    }

    public VehicleType findVehicleTypeByTypeName(String typeName) {
        return typeRepository.findVehicleTypeByTypeName(typeName);
    }
}
