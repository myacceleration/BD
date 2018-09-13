package com.acc.race.demo.rest;

import com.acc.race.demo.model.User;
import com.acc.race.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/users")
public class UserEndpoint {

    @Autowired
    UserRepository userRepo;

    @GET
    @Produces("application/json")
    public Response getUserByLogin(@QueryParam("login")String login) {
        System.out.println(".............Login: " + login);
        if( login == null) {
            return Response.ok(userRepo.findAll()).build();
        } else {
            User u = userRepo.findByLogin(login);
            if(u == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                return Response.ok(u).build();
            }
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(User u) {
        if(u.getLogin() == null || "".equals(u.getLogin())){
            return Response.status(Response.Status.BAD_REQUEST).entity("Pusty login").build();
        }
        if(u.getName() != null && u.getName().length() < 3) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Nazwa powinna miec 3 znaki").build();
        }
        if(u.getPassword() != null && u.getPassword().length() < 3) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Haslo powinno miec 3 znaki").build();
        }
        if(userRepo.findByLogin(u.getLogin()) != null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Login juz istnieje").build();
        }
        userRepo.saveUser(u);
        System.out.println("User registered:"+u.getLogin());
        return Response.ok().build();
    }
}
