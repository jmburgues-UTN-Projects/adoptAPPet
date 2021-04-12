package edu.utn.adoptAPPet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Data
@Entity
public class Cat extends Pet {
    private String hairLength;

    @Override
    public PetType petType(){
        return PetType.CAT;
    }
}
