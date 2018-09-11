package com.acc.race.demo.rest;

import com.acc.race.demo.model.Score;
import com.acc.race.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/scores")
public class ScoreEndpoint {

    @Autowired
    ScoreRepository scoreRepo;

    @GET
    @Produces("application/json")
    public List<Score> getScores() {
        return scoreRepo.findAll();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void savScore(Score s) {
        // TODO skoczyc
        scoreRepo.saveScore(s);
    }

    @GET
    @Path("{carId}")
    @Produces("application/json")
    public List<Score> getScoresByCar(@PathParam("carId")Long carId) {
        System.out.println("Car id: "+carId);
        return scoreRepo.findByCar(carId);
    }
}
