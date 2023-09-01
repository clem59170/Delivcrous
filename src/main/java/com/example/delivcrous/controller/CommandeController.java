package com.example.delivcrous.controller;

import com.example.delivcrous.model.Commande;
import com.example.delivcrous.service.CommandeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCommande(Commande commande, @QueryParam("user_id") Long user_id) {
        commandeService.createCommande(commande, user_id);
    }
}
