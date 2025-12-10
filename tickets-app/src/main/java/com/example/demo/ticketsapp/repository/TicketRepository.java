package com.example.demo.ticketsapp.repository;

import com.example.demo.ticketsapp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Interface Repository pour l'entité Ticket.
 * Étend JpaRepository pour bénéficier des méthodes CRUD automatiques.
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // --- Méthodes de Filtrage Personnalisées (Requis par l'énoncé) ---

    /**
     * Permet de trouver les tickets par leur statut (Nouveau, En cours, Résolu).
     * Spring génère la requête SQL automatiquement.
     * @param statut Le statut du ticket (doit correspondre à l'énumération Statut dans l'entité Ticket).
     * @return La liste des tickets correspondant au statut.
     */
    List<Ticket> findByStatut(Ticket.Statut statut);

    /**
     * Permet de trouver les tickets par leur priorité (Urgent, Moyen, Faible).
     * @param priorite La priorité du ticket (doit correspondre à l'énumération Priorite).
     * @return La liste des tickets correspondant à la priorité.
     */
    List<Ticket> findByPriorite(Ticket.Priorite priorite);

    /**
     * Permet de rechercher les tickets dont le titre contient un certain mot-clé,
     * en ignorant la casse (majuscules/minuscules).
     * @param titre Le mot-clé à rechercher dans le titre.
     * @return La liste des tickets contenant le mot-clé dans le titre.
     */
    List<Ticket> findByTitreContainingIgnoreCase(String titre);

    // Vous pourriez aussi ajouter une recherche par description si nécessaire :
    // List<Ticket> findByDescriptionContainingIgnoreCase(String description);
}