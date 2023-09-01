package com.example.delivcrous.service;

import com.example.delivcrous.model.Utilisateur;
import com.example.delivcrous.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public void createUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur findByUsername(String username) {
        return utilisateurRepository.findByUsername(username);
    }
}
