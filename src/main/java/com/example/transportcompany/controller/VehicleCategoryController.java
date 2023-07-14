package com.example.transportcompany.controller;

import com.example.transportcompany.model.VehicleCategory;
import com.example.transportcompany.service.VehicleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleCategoryController {
    private final VehicleCategoryService categoryService;

    @Autowired
    public VehicleCategoryController(VehicleCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    @ResponseBody
    List<VehicleCategory> getAllCategories() {
        return categoryService.findAll();
    }
}
