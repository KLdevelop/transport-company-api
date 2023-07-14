package com.example.transportcompany.dto;

import java.util.Optional;

public class VehicleFilterDto {
    private Optional<String> brand;
    private Optional<String> model;
    private Optional<String> category;
    private Optional<String> type;
    private Optional<Integer> releaseYear;
    private Optional<Boolean> hasTrailer;

    public VehicleFilterDto(Optional<String> brand, Optional<String> model, Optional<String> category, Optional<String> type, Optional<Integer> releaseYear, Optional<Boolean> hasTrailer) {
        this.brand = brand;
        this.model = model;
        this.category = category;
        this.type = type;
        this.releaseYear = releaseYear;
        this.hasTrailer = hasTrailer;
    }

    public Optional<String> getBrand() {
        return brand;
    }

    public void setBrand(Optional<String> brand) {
        this.brand = brand;
    }

    public Optional<String> getModel() {
        return model;
    }

    public void setModel(Optional<String> model) {
        this.model = model;
    }

    public Optional<String> getCategory() {
        return category;
    }

    public void setCategory(Optional<String> category) {
        this.category = category;
    }

    public Optional<String> getType() {
        return type;
    }

    public void setType(Optional<String> type) {
        this.type = type;
    }

    public Optional<Integer> getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Optional<Integer> releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Optional<Boolean> getHasTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(Optional<Boolean> hasTrailer) {
        this.hasTrailer = hasTrailer;
    }
}
