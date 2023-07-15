package com.example.transportcompany.repository;

import com.example.transportcompany.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    VehicleType findVehicleTypeByTypeName(String typeName);
}
