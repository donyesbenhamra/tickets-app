package com.example.demo.ticketsapp.service;

import com.example.demo.ticketsapp.model.Utilisateur;
import com.example.demo.ticketsapp.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // CREATE
    public Utilisateur createUser(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    // GET ALL
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    // GET BY ID
    public Utilisateur getUserById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Utilisateur updateUser(Long id, Utilisateur newUser) {
        return utilisateurRepository.findById(id).map(old -> {
            old.setNom(newUser.getNom());
            old.setEmail(newUser.getEmail());
            return utilisateurRepository.save(old);
        }).orElse(null);
    }

    // DELETE
    public void deleteUser(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
