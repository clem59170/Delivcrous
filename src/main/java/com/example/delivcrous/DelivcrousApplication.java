package com.example.delivcrous;
import com.example.delivcrous.controller.UtilisateurController;
import com.example.delivcrous.repository.*;
import com.example.delivcrous.service.UtilisateurService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.delivcrous.model.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class DelivcrousApplication {

    public static void main(String[] args) {
        SpringApplication.run(DelivcrousApplication.class, args);
    }
    @Bean
    public CommandLineRunner initData(UtilisateurRepository utilisateurRepository,
                                      PlatRepository platRepository,
                                      AllergeneRepository allergeneRepository,
                                      CommandeRepository commandeRepository,
                                      PanierRepository panierRepository,
                                      PlatPanierRepository platPanierRepository,
                                      PlatCommandeRepository platCommandeRepository, UtilisateurService utilisateurService) {
        return args -> {
            // Insertion de données dans la table Utilisateur
            Utilisateur user1 = new Utilisateur("jdoe","jdoe@gmail.com", "Password123!", "John", "Doe", 100.0);
            Utilisateur user2 = new Utilisateur("asmith", "asmith@gmail.com","Password123!", "Alice", "Smith", 150.0);
            Utilisateur user3 = new Utilisateur("mjones", "mjones@gmail.com", "Password123!", "Michael", "Jones", 200.0);

            utilisateurService.createUtilisateur(user1);
            utilisateurService.createUtilisateur(user2);
            utilisateurService.createUtilisateur(user3);

            user1 = utilisateurRepository.findByUsername("jdoe");
            user2 = utilisateurRepository.findByUsername("asmith");
            user3 = utilisateurRepository.findByUsername("mjones");

            // Insertion de données dans la table Plat
            Plat plat1 = platRepository.save(new Plat("Pizza", "Simple mais délicieux", (long)12, "https://drive.google.com/uc?export=view&id=1y_gRLdRXaPae66N0hVmGkgT3B3ZwnBft", "Pizza", "gluten, tomates"));
            Plat plat2 = platRepository.save(new Plat("Raviolis", "Pâtes farcies à la ricotta", (long)15.0, "https://drive.google.com/uc?export=view&id=1bBh85SKNHP_ST5mjf1kCxvqyUHCOsbSW", "Pâtes", "gluten, fromage"));
            Plat plat3 = platRepository.save(new Plat("Burger", "Délicieux burger au bon goût de cheddar", (long)18.0, "https://drive.google.com/uc?export=view&id=1Lz5dp7L0k6x03HVQ8kWeVDs8qK0upmtW", "Burger", "pomme de terre, oeuf"));
            Plat plat4 = platRepository.save(new Plat("Tacos", "Goute moi ça chacal", (long)18.0, "https://drive.google.com/uc?export=view&id=15zqJb6Aw2WRItPWQvTqV7OyFtxMPlR66", "Tacos", "gluten"));
            Plat plat5 = platRepository.save(new Plat("Sushis", "Bienvenu au Japon", (long)18.0, "https://drive.google.com/uc?export=view&id=11qX96a11sB9GKX1e5Cj7_nVlcAdnuDIo", "Asiatique", "fruits de mer"));
            Plat plat6 = platRepository.save(new Plat("Pâtes Bolognaises", "Delicioso mama", (long)18.0, "https://drive.google.com/uc?export=view&id=1OnS4h8h4pvBfNX-EJXXxJLWFoHEApdR8", "Viande", "pomme de terre, oeuf"));


            // Insertion de données dans la table Allergene
            Allergene allergene1 = allergeneRepository.save(new Allergene("Gluten"));
            Allergene allergene2 = allergeneRepository.save(new Allergene("Arachide"));
            Allergene allergene3 = allergeneRepository.save(new Allergene("Lactose"));

            // Insertion de données dans la table Commande
            Commande commande1 = commandeRepository.save(new Commande(user1, "123 Rue ABC", "Livré", new SimpleDateFormat("yyy-MM-dd").parse("2023-08-31")));
            Commande commande2 = commandeRepository.save(new Commande(user2, "456 Rue DEF", "En préparation", new SimpleDateFormat("yyy-MM-dd").parse("2023-08-30")));

            // Insertion de données dans la table Panier
            Panier panier1 = panierRepository.save(new Panier(user1));
            Panier panier2 = panierRepository.save(new Panier(user2));
            Panier panier3 = panierRepository.save(new Panier(user3));

            // Insertion de données dans la table Plat_Panier
            platPanierRepository.save(new PlatPanier(plat1, panier1, 2));
            platPanierRepository.save(new PlatPanier(plat2, panier2, 1));
            platPanierRepository.save(new PlatPanier(plat3, panier3, 2));

            // Insertion de données dans la table Plat_Commande
            platCommandeRepository.save(new PlatCommande(plat1, commande1, 1));
            platCommandeRepository.save(new PlatCommande(plat2, commande2, 2));
            platCommandeRepository.save(new PlatCommande(plat3, commande1, 1));
        };
    }
}
