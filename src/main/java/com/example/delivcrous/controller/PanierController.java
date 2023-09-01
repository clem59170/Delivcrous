package com.example.delivcrous.controller;

import com.example.delivcrous.model.Panier;
import com.example.delivcrous.service.PanierService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/paniers")
public class PanierController {

    @Autowired
    private PanierService panierService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Panier> getAllPaniers() {
        return panierService.getAllPaniers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPanier(Panier panier, @QueryParam("user_id") Long user_id) {
        panierService.createPanier(panier, user_id);
    }
}
