package com.example.transportcompany.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public VehicleCategory(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public VehicleCategory() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Column(name = "category_name")
    private String categoryName;
}
