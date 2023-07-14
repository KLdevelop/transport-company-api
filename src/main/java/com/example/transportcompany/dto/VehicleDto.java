package com.example.transportcompany.dto;

public class VehicleDto {
    private Long id;
    private String brand;
    private String model;
    private String category;
    private String stateNumber;
    private String type;
    private int releaseYear;
    private boolean hasTrailer;

    public VehicleDto(Long id, String brand, String model, String category, String stateNumber, String type, Integer releaseYear, boolean hasTrailer) {
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }
}
