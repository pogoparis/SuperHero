package fr.eni.superhero.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private boolean estProfessionnelle;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private SuperHero responsable;

    public Team(String nom, SuperHero responsable) {
        this.nom = nom;
        this.responsable = responsable;
    }
}