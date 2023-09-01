package com.example.delivcrous.service;

import com.example.delivcrous.model.Commande;
import com.example.delivcrous.model.Utilisateur;
import com.example.delivcrous.repository.CommandeRepository;
import com.example.delivcrous.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public void createCommande(Commande commande, Long user_id) {
        System.out.println("user_id: " + user_id); // Logging user ID
        Utilisateur utilisateur = utilisateurRepository.findById(user_id).orElseThrow(
                ()  -> new RuntimeException("Utilisateur non trouvé")
        );
        commande.setUtilisateur(utilisateur);
        commandeRepository.save(commande);
    }
}
