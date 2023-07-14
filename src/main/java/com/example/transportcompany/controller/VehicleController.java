package com.example.transportcompany.controller;

import com.example.transportcompany.dto.VehicleDto;
import com.example.transportcompany.dto.VehicleFilterDto;
import com.example.transportcompany.model.Vehicle;
import com.example.transportcompany.service.VehicleService;
import com.example.transportcompany.util.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    private final VehicleService vehicleService;

    @GetMapping("/vehicles")
    @ResponseBody
    List<VehicleDto> getAllVehicles() {
        final List<Vehicle> vehicles = vehicleService.findAll();

        return vehicles.stream().map(MappingUtils::mapToVehicleDto).toList();
    }

    @PostMapping("/filter")
    @ResponseBody
    List<VehicleDto> filterVehicles(@RequestBody VehicleFilterDto filter) {
        final List<Vehicle> vehicles = vehicleService.filter(filter);

        return vehicles.stream().map(MappingUtils::mapToVehicleDto).toList();
    }
}
