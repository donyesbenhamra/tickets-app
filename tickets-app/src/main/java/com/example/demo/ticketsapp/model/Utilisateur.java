package com.example.demo.ticketsapp.model;

import jakarta.persistence.*;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    // TODO: Ajouter les constructeurs, getters et setters
}