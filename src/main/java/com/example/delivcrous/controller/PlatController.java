package com.example.delivcrous.controller;

import com.example.delivcrous.model.Plat;
import com.example.delivcrous.service.PlatService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/plats")
public class PlatController {

    @Autowired
    private PlatService platService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plat> getAllPlats() {
        return platService.getAllPlats();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPlat(Plat plat) {
        platService.createPlat(plat);
    }
}
