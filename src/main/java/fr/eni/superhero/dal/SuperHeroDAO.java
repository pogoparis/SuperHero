package fr.eni.superhero.dal;

import fr.eni.superhero.bo.SuperHero;
import fr.eni.superhero.bo.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SuperHeroDAO extends CrudRepository <SuperHero, Integer> {

    List<SuperHero> findByEquipe(Team equipe);

    SuperHero findByNom(String nom);
}
