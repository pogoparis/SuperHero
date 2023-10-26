package fr.eni.superhero;

import fr.eni.superhero.bll.SuperHeroExistsException;
import fr.eni.superhero.bll.SuperHeroService;
import fr.eni.superhero.bo.EnemyRole;
import fr.eni.superhero.bo.RelationEnnemi;
import fr.eni.superhero.bo.SuperHero;
import fr.eni.superhero.bo.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SuperHeroApplication implements CommandLineRunner {

	@Autowired
	SuperHeroService superHeroService;

	public static void main(String[] args) {
		SpringApplication.run(SuperHeroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Collections de pouvoirs
		List<String> superPouvoirsSuperman = Arrays.asList("Vol", "Force surhumaine", "Vision thermique");




		// Créer 8 super-héros
		SuperHero superman = superHeroService.ajouterSuperHero(new SuperHero("Superman", "Clark Kent", Arrays.asList("Vol", "Force surhumaine", "Vision thermique")));
		SuperHero batman = superHeroService.ajouterSuperHero(new SuperHero("Batman", "Bruce Wayne", Arrays.asList("Intelligence", "Maître du combat")));
		SuperHero wonderWoman = superHeroService.ajouterSuperHero(new SuperHero("Wonder Woman", "Diana Prince", Arrays.asList("Force surhumaine", "Lasso de vérité")));
		SuperHero spiderMan = superHeroService.ajouterSuperHero(new SuperHero("Spider-Man", "Peter Parker", Arrays.asList("Agilité accrue", "Toiles d'araignée")));
		SuperHero ironMan = superHeroService.ajouterSuperHero(new SuperHero("Iron Man", "Tony Stark", Arrays.asList("Armure surhumaine", "Intelligence")));
		SuperHero blackWidow = superHeroService.ajouterSuperHero(new SuperHero("Black Widow", "Natasha Romanoff", Arrays.asList("Maître du combat", "Espionnage")));
		SuperHero theFlash = superHeroService.ajouterSuperHero(new SuperHero("The Flash", "Barry Allen", Arrays.asList("Super vitesse", "Régénération rapide")));
		SuperHero aquaman = superHeroService.ajouterSuperHero(new SuperHero("Aquaman", "Arthur Curry", Arrays.asList("Contrôle des océans", "Force surhumaine")));


		try {
			SuperHero aquaman2 = superHeroService.ajouterSuperHero(new SuperHero("Aquaman", "Arthur Curry", Arrays.asList("Contrôle des océans", "Force surhumaine")));
		} catch (SuperHeroExistsException e) {
			System.err.println("Erreur : Le super-héros avec ce nom existe déjà.");
		}

// Créer 3 équipes en utilisant le service
		Team equipe1 = superHeroService.creerEquipe("Justice League", false);
		Team equipe2 = superHeroService.creerEquipe("Avengers", true);
		Team equipe3 = superHeroService.creerEquipe("X-Men", false);

// Associer les super-héros à leurs équipes respectives
		superman.setEquipe(equipe1);
		System.out.println(superman.getNom() + " associé à " + equipe1.getNom());
		batman.setEquipe(equipe1);
		System.out.println(batman.getNom() + " associé à " + equipe1.getNom());
		wonderWoman.setEquipe(equipe1);
		System.out.println(wonderWoman.getNom() + " associé à " + equipe1.getNom());
		spiderMan.setEquipe(equipe2);
		System.out.println(spiderMan.getNom() + " associé à " + equipe2.getNom());
		ironMan.setEquipe(equipe2);
		System.out.println(ironMan.getNom() + " associé à " + equipe2.getNom());
		blackWidow.setEquipe(equipe2);
		System.out.println(blackWidow.getNom() + " associé à " + equipe2.getNom());
		theFlash.setEquipe(equipe1);
		System.out.println(theFlash.getNom() + " associé à " + equipe1.getNom());
		aquaman.setEquipe(equipe3);
		System.out.println(aquaman.getNom() + " associé à " + equipe3.getNom());

		superHeroService.nommerChefEquipe(equipe2, blackWidow);

		// Créer des super-vilains
		SuperHero joker = superHeroService.ajouterSuperHero(new SuperHero("Joker", "Inconnu", Arrays.asList("Rire démoniaque", "Stratège fou")));
		SuperHero luthor = superHeroService.ajouterSuperHero(new SuperHero("Lex Luthor", "Lex Luthor", Arrays.asList("Génie criminel", "Ressources illimitées")));
		SuperHero riddler = superHeroService.ajouterSuperHero(new SuperHero("Riddler", "Edward Nigma", Arrays.asList("Énigmes complexes", "Obsession pour les énigmes")));
		SuperHero twoFace = superHeroService.ajouterSuperHero(new SuperHero("Two-Face", "Harvey Dent", Arrays.asList("Décisions au hasard", "Double personnalité")));
		SuperHero cheetah = superHeroService.ajouterSuperHero(new SuperHero("Cheetah", "Barbara Ann Minerva", Arrays.asList("Vitesse surhumaine", "Force surhumaine")));


/*		//ENNEMIS
		RelationEnnemi ennemi1 = new RelationEnnemi(superman, joker, EnemyRole.ENNEMI_JURE);
		RelationEnnemi ennemi2 = new RelationEnnemi(superman, luthor, EnemyRole.ENNEMI_JURE);
		RelationEnnemi ennemi3 = new RelationEnnemi(batman, riddler, EnemyRole.ENNEMI_JURE);
		RelationEnnemi ennemi4 = new RelationEnnemi(batman, twoFace, EnemyRole.ENNEMI_JURE);
		RelationEnnemi ennemi5 = new RelationEnnemi(wonderWoman, cheetah, EnemyRole.ENNEMI_JURE);*/
	}




}
