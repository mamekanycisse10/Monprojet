package com.mame.monprojet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique [cite: 10]

    @Column(nullable = false)
    private String title; // Titre de la tâche [cite: 11]

    private String description; // Description [cite: 12]

    @Column(nullable = false)
    private String status; // Statut (En cours, Terminé) [cite: 13]
}