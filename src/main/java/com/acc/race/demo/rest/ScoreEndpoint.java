package com.acc.race.demo.rest;

import com.acc.race.demo.model.Car;
import com.acc.race.demo.model.Score;
import com.acc.race.demo.model.ScoreDto;
import com.acc.race.demo.model.User;
import com.acc.race.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/scores")
public class ScoreEndpoint {

    @Autowired
    ScoreRepository scoreRepo;

    @GET
    @Produces("application/json")
    public List<ScoreDto> getScores() {
        List<ScoreDto> result = new ArrayList<>();
        for(Score s : scoreRepo.findAll()) {
            result.add(s.transform());
        }
        return result;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void savScore(ScoreDto s) {
        Score score = new Score();
        score.setValue(s.getValue());
        score.setDate(s.getDate());

        Car c = new Car();
        c.setId(s.getCarId());
        score.setCar(c);

        User u = new User();
        u.setId(s.getUserId());
        score.setUser(u);
        scoreRepo.saveScore(score);
    }

    @GET
    @Path("{carId}")
    @Produces("application/json")
    public List<ScoreDto> getScoresByCar(@PathParam("carId")Long carId) {
        System.out.println("Car id: "+carId);
        List<ScoreDto> result = new ArrayList<>();
        for(Score s : scoreRepo.findByCar(carId)) {
            result.add(s.transform());
        }
        return result;
    }
}
