package com.example.delivcrous.controller;

import com.example.delivcrous.model.Utilisateur;
import com.example.delivcrous.service.UtilisateurService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Path("/utilisateurs")
public class UtilisateurController {

    @Inject
    private UtilisateurService utilisateurService;
    @Inject
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GET
    @Path("/getutilisateurs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUtilisateur(Utilisateur utilisateur) {
        utilisateurService.createUtilisateur(utilisateur);
    }

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Utilisateur loginUser) {
        Utilisateur user = utilisateurService.findByUsername(loginUser.getUsername());
        if (user != null && bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            String token = Jwts.builder()
                    .setSubject(user.getUsername())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                    .signWith(key)  // Utilisation de la nouvelle méthode signWith
                    .compact();
            return Response.ok(token).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
