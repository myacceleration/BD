package com.acc.race.demo.rest;

import com.acc.race.demo.model.Car;
import com.acc.race.demo.model.User;
import com.acc.race.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/cars")
public class CarEndpoint {

    @Autowired
    CarRepository carRepo;

    @GET
    @Produces("application/json")
    public List<Car> getCars() {
        return carRepo.findAll();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCar(Car c) {
        carRepo.saveCar(c);
    }
}
