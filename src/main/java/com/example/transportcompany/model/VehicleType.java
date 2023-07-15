package com.example.transportcompany.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_type")
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public VehicleType(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public VehicleType() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Column(name = "type_name", nullable = false)
    private String typeName;
}
