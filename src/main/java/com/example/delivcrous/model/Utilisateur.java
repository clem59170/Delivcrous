package com.example.delivcrous.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @Column(name = "user_id")

    private Long user_id;
    @NotEmpty(message = "Le nom d'utilisateur ne peut pas être vide")
    @Size(min = 3, max = 20, message = "Le nom d'utilisateur doit avoir entre 3 et 20 caractères")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "Seuls les chiffres et les lettres sont autorisés pour le nom d'utilisateur")
    private String username;

    @Email(message = "Doit être une adresse e-mail valide")
    private String email;

    @NotEmpty(message = "Le mot de passe ne peut pas être vide")
    @Size(min = 8, message = "Le mot de passe doit avoir au moins 8 caractères")
    //@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$",
    //        message = "Le mot de passe doit contenir au moins une majuscule, une minuscule, un chiffre et un caractère spécial parmi @$!%*?&#")
    private String password;
    private String nom;
    private String prenom;
    private Double solde_crous;

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Panier panier;

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
    public String getEmail() { return email; }
    public void setEmail() { this.email = email; }

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

    public Utilisateur(String username, String email, String password, String nom, String prenom, Double solde_crous) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.solde_crous = solde_crous;
    }

    public Utilisateur(){}
}
