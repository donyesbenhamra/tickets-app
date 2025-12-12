package com.example.demo.ticketsapp.controller;

import com.example.demo.ticketsapp.model.Utilisateur;
import com.example.demo.ticketsapp.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur user) {
        return utilisateurService.createUser(user);
    }

    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Utilisateur getById(@PathVariable Long id) {
        return utilisateurService.getUserById(id);
    }

    @PutMapping("/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur user) {
        return utilisateurService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateurService.deleteUser(id);
    }
}
