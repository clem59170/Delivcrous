package com.example.delivcrous.model;

import jakarta.persistence.*;

@Entity
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "panier_sequence")
    @SequenceGenerator(name = "panier_sequence", sequenceName = "panier_sequence", allocationSize = 1)
    private Long panier_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Utilisateur utilisateur;

    // Getters et Setters

    public Long getPanier_id() {
        return panier_id;
    }

    public void setPanier_id(Long panier_id) {
        this.panier_id = panier_id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Panier(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Panier() {}
}
