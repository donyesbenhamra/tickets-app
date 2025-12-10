package com.example.demo.ticketsapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priorite priorite;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    private String assigneA;

    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;

    // --- ENUMS INTERNES ---

    public enum Priorite {
        URGENT, MOYEN, FAIBLE
    }

    public enum Statut {
        NOUVEAU, EN_COURS, RESOLU
    }

    // --- CONSTRUCTEUR PAR DÉFAUT (Obligatoire par JPA) ---

    public Ticket() {
    }

    // --- GESTION AUTOMATIQUE DES DATES ---

    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
        dateModification = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dateModification = LocalDateTime.now();
    }

    // --- GETTERS & SETTERS (Doivent être ajoutés pour tous les champs) ---
    // Note: Pour la simplicité, seuls quelques-uns sont affichés ici.
    // Il faut ajouter les méthodes pour tous les champs (titre, description, priorite, statut, assigneA, etc.)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    // ... (Ajouter ici tous les autres Getters et Setters pour Priorite, Statut, Description, AssigneA, etc.)

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssigneA() {
        return assigneA;
    }

    public void setAssigneA(String assigneA) {
        this.assigneA = assigneA;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    // NOTE: Il n'y a généralement pas de setter pour dateCreation/dateModification car ils sont gérés automatiquement.
}