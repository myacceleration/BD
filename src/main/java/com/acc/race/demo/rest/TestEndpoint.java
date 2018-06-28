package com.acc.race.demo.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("/")
public class TestEndpoint {

    @GET
    @Produces("text/plain")
    public Response get() {
        return Response.ok("Server is up...").build();
    }
}
