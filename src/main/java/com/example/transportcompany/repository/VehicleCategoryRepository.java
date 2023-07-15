package com.example.transportcompany.repository;

import com.example.transportcompany.model.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Long> {
    VehicleCategory findVehicleCategoryByCategoryName(String categoryName);
}
