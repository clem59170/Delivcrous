package com.example.delivcrous;
import com.example.delivcrous.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.delivcrous.model.*;

import java.text.SimpleDateFormat;


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
                                      PlatCommandeRepository platCommandeRepository) {
        return args -> {
            // Insertion de données dans la table Utilisateur
            Utilisateur user1 = utilisateurRepository.save(new Utilisateur("jdoe", "password123", "John", "Doe", 100.0));
            Utilisateur user2 = utilisateurRepository.save(new Utilisateur("asmith", "password123", "Alice", "Smith", 150.0));
            Utilisateur user3 = utilisateurRepository.save(new Utilisateur("mjones", "password123", "Michael", "Jones", 200.0));

            // Insertion de données dans la table Plat
            Plat plat1 = platRepository.save(new Plat("Pizza Margherita", "Simple mais délicieux", (long)12, "url1", "Pizza"));
            Plat plat2 = platRepository.save(new Plat("Ravioli", "Pâtes farcies à la ricotta", (long)15.0, "url2", "Pâtes"));
            Plat plat3 = platRepository.save(new Plat("Steak Frites", "Classique français", (long)18.0, "url3", "Viande"));

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
