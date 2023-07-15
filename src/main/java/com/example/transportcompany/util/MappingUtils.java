package com.example.transportcompany.util;

import com.example.transportcompany.dto.VehicleDto;
import com.example.transportcompany.model.Vehicle;
import com.example.transportcompany.model.VehicleCategory;
import com.example.transportcompany.model.VehicleType;
import com.example.transportcompany.service.VehicleCategoryService;
import com.example.transportcompany.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MappingUtils {
    private static VehicleCategoryService categoryService;
    private static VehicleTypeService vehicleTypeService;

    @Autowired
    public MappingUtils(VehicleCategoryService categoryService, VehicleTypeService vehicleTypeService) {
        this.categoryService = categoryService;
        this.vehicleTypeService = vehicleTypeService;
    }

    public static VehicleDto mapToVehicleDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setId(vehicle.getId());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setCategory(vehicle.getCategory().getCategoryName());
        vehicleDto.setStateNumber(vehicle.getStateNumber());
        vehicleDto.setType(vehicle.getType().getTypeName());
        vehicleDto.setReleaseYear(vehicle.getReleaseYear());
        vehicleDto.setHasTrailer(vehicle.getHasTrailer());

        return vehicleDto;
    }

    public static Vehicle mapToVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(vehicleDto.getId());
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());

        VehicleCategory vehicleCategory = categoryService.findVehicleCategoryByCategoryName(vehicleDto.getCategory());
        vehicle.setCategory(vehicleCategory);

        VehicleType vehicleType = vehicleTypeService.findVehicleTypeByTypeName(vehicleDto.getType());
        vehicle.setType(vehicleType);

        vehicle.setReleaseYear(vehicleDto.getReleaseYear());
        vehicle.setHasTrailer(vehicleDto.isHasTrailer());
        vehicle.setStateNumber(vehicleDto.getStateNumber());

        return vehicle;
    }
}
