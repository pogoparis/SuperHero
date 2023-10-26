package fr.eni.superhero.bll;

import fr.eni.superhero.bo.SuperHero;
import fr.eni.superhero.bo.Team;
import fr.eni.superhero.dal.SuperHeroDAO;
import fr.eni.superhero.dal.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    @Autowired
    private SuperHeroDAO superHeroDAO;
    @Autowired
    private TeamDAO teamDAO;

    @Override
    public SuperHero ajouterSuperHero(SuperHero superHero) {
        SuperHero existingSuperHero = superHeroDAO.findByNom(superHero.getNom());
        if (existingSuperHero != null) {
            throw new SuperHeroExistsException("Le super-héros avec ce nom existe déjà.");
        }
        System.out.println("Ajout d'un super-héros : " + superHero.getNom());
        return (SuperHero) superHeroDAO.save(superHero);
    }

    @Override
    public SuperHero mettreAJourSuperHero(SuperHero superHero) {
        System.out.println("Mise à jour du super-héros : " + superHero.getNom());
        return (SuperHero) superHeroDAO.save(superHero);
    }

    @Override
    public void supprimerSuperHero(Integer superHeroId) {
        System.out.println("Suppression du super-héros avec l'ID : " + superHeroId);
        superHeroDAO.deleteById(Math.toIntExact(superHeroId));
    }

    @Override
    public List<SuperHero> rechercherSuperHerosParEquipe(Team equipe) {
        System.out.println("Recherche de super-héros par équipe : " + equipe.getNom());
        return superHeroDAO.findByEquipe(equipe);
    }

    @Override
    public Team creerEquipe(String teamName, boolean isProfessional) {
        Team team = new Team();
        team.setNom(teamName);
        team.setEstProfessionnelle(isProfessional);
        if (isProfessional) {
            System.out.println("Attention " + team.getNom() +" : est une équipe professionnelle, elle nécessite la nomination d'un super-héros en tant que chef.");
        }
        return teamDAO.save(team);
    }

    @Override
    public Team mettreAJourEquipe(Team equipe) {
        Team updatedTeam = teamDAO.save(equipe);
        System.out.println("Équipe mise à jour avec succès : " + updatedTeam.getNom());
        return updatedTeam;
    }

    @Override
    public void supprimerEquipe(Integer equipeId) {
        // Ajoutez votre logique pour supprimer une équipe.
        teamDAO.deleteById(equipeId);
        System.out.println("Équipe supprimée avec succès, ID : " + equipeId);
    }

    @Override
    public List<Team> listeEquipes() {
        List<Team> teams = (List<Team>) teamDAO.findAll();
        return teams;
    }

    @Override
    public void nommerChefEquipe(Team equipe, SuperHero superHero) {
        if (equipe.isEstProfessionnelle()) {
            if (superHero != null && superHero.getEquipe() == equipe) {
                if (equipe.getResponsable() == null) {
                    equipe.setResponsable(superHero);
                    System.out.println(superHero.getNom() + " a été promu Chef de l'équipe " + equipe.getNom());
                    teamDAO.save(equipe);
                } else {
                    System.out.println("Une équipe ne peut avoir qu'un seul chef.");
                }
            } else {
                System.out.println("Le super-héros chef doit être membre de l'équipe professionnelle.");
            }
        } else {
            System.out.println("Vous ne pouvez nommer un chef d'équipe que pour les équipes professionnelles.");
        }
    }

}
