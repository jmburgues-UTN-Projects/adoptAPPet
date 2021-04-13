package edu.utn.adoptAPPet.exceptions;

public class DoesntExistsException extends RuntimeException{
    public DoesntExistsException(String entity, String value){
        super(entity + " " + value + " " + " does not exists." );
    }
}
