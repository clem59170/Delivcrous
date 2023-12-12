package com.example.delivcrous;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // Controllers
        register(com.example.delivcrous.controller.AllergeneController.class);
        register(com.example.delivcrous.controller.CommandeController.class);
        register(com.example.delivcrous.controller.PanierController.class);
        register(com.example.delivcrous.controller.PlatCommandeController.class);
        register(com.example.delivcrous.controller.PlatController.class);
        register(com.example.delivcrous.controller.PlatPanierController.class);
        register(com.example.delivcrous.controller.UtilisateurController.class);

    }
}
