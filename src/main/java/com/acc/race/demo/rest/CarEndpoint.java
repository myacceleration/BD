package com.acc.race.demo.rest;

import com.acc.race.demo.model.Car;
import com.acc.race.demo.model.User;
import com.acc.race.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/cars")
public class CarEndpoint {

    @Autowired
    CarRepository carRepo;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCar(Car c) {
        carRepo.saveCar(c);
    }

    @GET
    @Path("/brands")
    @Produces("application/json")
    public List<String> getBrands() {
        return carRepo.findManufacturers();
    }

    @GET
    @Produces("application/json")
    public Response getUserByLogin(@QueryParam("brand")String brand) {
        System.out.println(".............Brand: " + brand);
        if( brand == null) {
            return Response.ok(carRepo.findAll()).build();
        } else {
            List<Car> cars = carRepo.findByManufacturer(brand);
            if(cars.size() == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                return Response.ok(cars).build();
            }
        }
    }
}
