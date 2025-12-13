package com.example.demo.ticketsapp.repository;

import com.example.demo.ticketsapp.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
