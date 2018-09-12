package com.acc.race.demo.model;

import com.acc.race.demo.Utils;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date date;

    @Column
    private Float value;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public ScoreDto transform(){
        ScoreDto result = new ScoreDto();
        result.setDate(this.getDate());
        result.setId(this.getId());
        result.setValue(this.getValue());
        if(this.getCar() != null) {
            result.setCarId(this.getCar().getId());
        }
        if(this.getUser() != null) {
            result.setUserId(this.getUser().getId());
            result.setUsername(Utils.empty(this.getUser().getName()) ? this.getUser().getLogin() : this.getUser().getName());
        }
        return result;
    }
}
