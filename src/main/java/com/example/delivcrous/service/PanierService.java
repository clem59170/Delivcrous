package com.example.delivcrous.service;

import com.example.delivcrous.repository.UtilisateurRepository;
import com.example.delivcrous.model.Panier;
import com.example.delivcrous.model.Utilisateur;
import com.example.delivcrous.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    public void createPanier(Panier panier, Long user_id) {
        System.out.println("user_id: " + user_id); // Logging user ID
                Utilisateur utilisateur = utilisateurRepository.findById(user_id).orElseThrow(
                ()  -> new RuntimeException("Utilisateur non trouvé")
        );
        panier.setUtilisateur(utilisateur);
        panierRepository.save(panier);
    }

}
