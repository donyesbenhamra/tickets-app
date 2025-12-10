package com.example.demo.ticketsapp.model;
import com.example.demo.ticketsapp.model.Statut;
import com.example.demo.ticketsapp.model.Priorite;
import com.example.demo.ticketsapp.model.Utilisateur;


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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilisateur assigneA;

    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;

    // Constructeur par défaut (obligatoire pour JPA)
    public Ticket() {}

    // Gestion auto des dates
    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
        dateModification = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dateModification = LocalDateTime.now();
    }

    // --------- Getters & Setters ---------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Priorite getPriorite() { return priorite; }
    public void setPriorite(Priorite priorite) { this.priorite = priorite; }

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }

    public Utilisateur getAssigneA() { return assigneA; }
    public void setAssigneA(Utilisateur assigneA) { this.assigneA = assigneA; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public LocalDateTime getDateModification() { return dateModification; }
}
