package com.example.delivcrous.controller;

import com.example.delivcrous.model.Allergene;
import com.example.delivcrous.service.AllergeneService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/allergenes/")
public class AllergeneController {

    @Autowired
    private AllergeneService allergeneService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Allergene> getAllAllergenes() {
        return allergeneService.getAllAllergenes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAllergene(Allergene allergene) {
        allergeneService.createAllergene(allergene);
    }
}
