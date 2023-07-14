package com.example.transportcompany.util;

import com.example.transportcompany.dto.VehicleDto;
import com.example.transportcompany.model.Vehicle;

public class MappingUtils {
    public static VehicleDto mapToVehicleDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setId(vehicle.getId());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setCategory(vehicle.getCategory().getCategoryName());
        vehicleDto.setStateNumber(vehicle.getStateNumber());
        vehicleDto.setType(vehicle.getType().getTypeName());
        vehicleDto.setHasTrailer(vehicle.getHasTrailer());

        return vehicleDto;
    }
}
