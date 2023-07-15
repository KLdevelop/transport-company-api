package com.example.transportcompany.service;

import com.example.transportcompany.model.VehicleCategory;
import com.example.transportcompany.repository.VehicleCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleCategoryService {
    private final VehicleCategoryRepository categoryRepository;

    @Autowired
    public VehicleCategoryService(VehicleCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<VehicleCategory> findAll() {
        return categoryRepository.findAll();
    }

    public VehicleCategory findVehicleCategoryByCategoryName(String categoryName) {
        return categoryRepository.findVehicleCategoryByCategoryName(categoryName);
    }
}
