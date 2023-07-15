package com.example.transportcompany.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class VehicleDto {
    private Long id;

    @NotNull
    @NotEmpty
    private String brand;

    @NotNull
    @NotEmpty
    private String model;

    @NotNull
    @NotEmpty
    private String category;

    @NotNull
    @NotEmpty
    private String stateNumber;

    @NotNull
    private String type;

    @NotNull
    private Integer releaseYear;

    @NotNull
    private Boolean hasTrailer;

    public VehicleDto(Long id, String brand, String model, String category, String stateNumber, String type, Integer releaseYear, Boolean hasTrailer) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.stateNumber = stateNumber;
        this.type = type;
        this.releaseYear = releaseYear;
        this.hasTrailer = hasTrailer;
    }

    public VehicleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(Boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }
}
