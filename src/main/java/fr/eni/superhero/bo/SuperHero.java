package fr.eni.superhero.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class SuperHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nom;
    private String identiteSecrete;
    @ElementCollection
    private List<String> superPouvoirs;

    @ManyToOne
    private Team equipe;

    @ManyToMany
    @JoinTable(name = "superhero_enemies",
            joinColumns = @JoinColumn(name = "superhero_id"),
            inverseJoinColumns = @JoinColumn(name = "enemy_id"))
    private List<RelationEnnemi> enemies;

    public SuperHero(String nom, String identiteSecrete, List<String> superPouvoirs) {
        this.nom = nom;
        this.identiteSecrete = identiteSecrete;
        this.superPouvoirs = superPouvoirs;
    }
}
