package fr.eni.superhero.bll;

public class SuperHeroExistsException extends RuntimeException {

    public SuperHeroExistsException(String message) {
        super(message);
    }

}