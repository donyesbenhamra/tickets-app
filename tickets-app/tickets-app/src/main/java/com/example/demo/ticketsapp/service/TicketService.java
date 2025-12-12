package com.example.demo.ticketsapp.service;

import com.example.demo.ticketsapp.model.Ticket;
import com.example.demo.ticketsapp.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Lister tous les tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Créer un ticket
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Trouver un ticket par ID (utile pour la suite)
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    // Mettre à jour un ticket
    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        return ticketRepository.findById(id)
                .map(existing -> {
                    existing.setTitre(updatedTicket.getTitre());
                    existing.setDescription(updatedTicket.getDescription());
                    existing.setPriorite(updatedTicket.getPriorite());
                    existing.setStatut(updatedTicket.getStatut());
                    existing.setAssigneA(updatedTicket.getAssigneA());
                    return ticketRepository.save(existing);
                })
                .orElse(null);
    }

    // Supprimer un ticket
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
