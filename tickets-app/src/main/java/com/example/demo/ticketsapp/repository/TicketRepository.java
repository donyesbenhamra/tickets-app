package com.example.demo.ticketsapp.repository;

import com.example.demo.ticketsapp.model.Ticket;
import com.example.demo.ticketsapp.model.Statut;
import com.example.demo.ticketsapp.model.Priorite;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStatut(Statut statut);

    List<Ticket> findByPriorite(Priorite priorite);

    List<Ticket> findByTitreContainingIgnoreCase(String titre);
}
