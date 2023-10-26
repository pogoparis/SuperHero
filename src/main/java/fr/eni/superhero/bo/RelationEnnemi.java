package fr.eni.superhero.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RelationEnnemi {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private SuperHero superhero;

        @ManyToOne
        private SuperHero enemy;

        @Enumerated(EnumType.STRING)
        private EnemyRole role;

        public RelationEnnemi(SuperHero superman, SuperHero joker, EnemyRole enemyRole) {

        }
}
