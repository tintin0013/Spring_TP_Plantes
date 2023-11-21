package com.example.TP_Plantes.model;

public class Plante {

    private Integer id;
    private String nom;
    private String couleur;

    public Plante() {
    }

    public Plante(Integer id, String nom, String couleur) {
        this.id = id;
        this.nom = nom;
        this.couleur = couleur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", couleur='" + couleur + '\'' +
                '}';
    }
}
