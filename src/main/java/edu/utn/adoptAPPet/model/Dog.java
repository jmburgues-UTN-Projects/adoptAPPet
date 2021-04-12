package edu.utn.adoptAPPet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Data
@Entity
public class Dog extends Pet {
    private String breed;

    @Override
    public PetType petType(){
        return PetType.DOG;
    }
}
