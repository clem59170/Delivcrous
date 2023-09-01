package com.example.delivcrous.model;

import jakarta.persistence.*;

@Entity
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plat_sequence")
    @SequenceGenerator(name = "plat_sequence", sequenceName = "plat_sequence", allocationSize = 1)

    private Long plat_id;

    private String nom;
    private String description;
    private Long prix;
    private String image_url;
    private String categorie;

    public Long getPlat_id() {
        return plat_id;
    }

    public void setPlat_id(Long plat_id) {
        this.plat_id = plat_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Plat(String nom, String description, Long prix, String image_url, String categorie) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.image_url = image_url;
        this.categorie = categorie;
    }

    public Plat(){}
}
