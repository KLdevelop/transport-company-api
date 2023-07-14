package com.example.transportcompany.controller;

import com.example.transportcompany.model.VehicleType;
import com.example.transportcompany.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleTypeController {
    private final VehicleTypeService typeService;

    @Autowired
    public VehicleTypeController(VehicleTypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/types")
    @ResponseBody
    List<VehicleType> getAllTypes() {
        return typeService.findAll();
    }
}
