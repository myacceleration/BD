package com.acc.race.demo.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"manufacturer", "model"}))
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String manufacturer;

    @Column
    private String model;

    @Column
    private Float manufacturerScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getManufacturerScore() {
        return manufacturerScore;
    }

    public void setManufacturerScore(Float manufacturerScore) {
        this.manufacturerScore = manufacturerScore;
    }
}
