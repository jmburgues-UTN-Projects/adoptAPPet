package edu.utn.adoptAPPet.exceptions;

import lombok.Data;

@Data
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String entity, String value) {
        super(entity + " " + value + " already exists.");
    }
}
