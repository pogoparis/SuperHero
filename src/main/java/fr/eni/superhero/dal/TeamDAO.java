package fr.eni.superhero.dal;

import fr.eni.superhero.bo.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamDAO extends CrudRepository <Team, Integer> {
}
