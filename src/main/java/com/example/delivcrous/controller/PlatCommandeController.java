package com.example.delivcrous.controller;

import com.example.delivcrous.model.PlatCommande;
import com.example.delivcrous.service.PlatCommandeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/plat_commandes")
public class PlatCommandeController {

    @Autowired
    private PlatCommandeService platCommandeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlatCommande> getAllPlatCommandes() {
        return platCommandeService.getAllPlatCommandes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPlatCommande(PlatCommande platCommande, @QueryParam("commande_id") Long command_id, @QueryParam("plat_id") Long plat_id) {
        platCommandeService.createPlatCommande(platCommande, command_id, plat_id);
    }
}
