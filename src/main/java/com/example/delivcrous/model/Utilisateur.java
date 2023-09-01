package com.example.delivcrous.model;

import jakarta.persistence.*;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @Column(name = "user_id")

    private Long user_id;
    private String username;
    private String password;
    private String nom;
    private String prenom;
    private Double solde_crous;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Double getSolde_crous() {
        return solde_crous;
    }

    public void setSolde_crous(Double solde_crous) {
        this.solde_crous = solde_crous;
    }

    public Utilisateur(String username, String password, String nom, String prenom, Double solde_crous) {
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.solde_crous = solde_crous;
    }

    public Utilisateur(){}
}
