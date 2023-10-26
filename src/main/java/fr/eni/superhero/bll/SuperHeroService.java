package fr.eni.superhero.bll;

import fr.eni.superhero.bo.SuperHero;
import fr.eni.superhero.bo.Team;

import java.util.List;

public interface SuperHeroService {
    List<SuperHero> rechercherSuperHerosParEquipe(Team equipe);

    void supprimerSuperHero(Integer superHeroId);

    SuperHero mettreAJourSuperHero(SuperHero superHero);

    SuperHero ajouterSuperHero(SuperHero superHero);
    Team mettreAJourEquipe(Team equipe);
    Team creerEquipe(String teamName, boolean isProfessional);
    List<Team> listeEquipes();
    void supprimerEquipe(Integer equipeId);
    void nommerChefEquipe(Team equipe, SuperHero superHero);

}
