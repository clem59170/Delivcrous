package com.example.delivcrous.controller;

import com.example.delivcrous.model.Utilisateur;
import com.example.delivcrous.service.UtilisateurService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUtilisateur(Utilisateur utilisateur) {
        utilisateurService.createUtilisateur(utilisateur);
    }
}
