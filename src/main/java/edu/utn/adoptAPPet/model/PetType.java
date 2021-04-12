package edu.utn.adoptAPPet.model;

public enum PetType {
    DOG("Dog"),
    CAT("Cat");

    private String description;

    PetType(String description){
        this.description = description;
    }

    public static PetType find(String description){
        for(PetType n : values()){
            if(description.equalsIgnoreCase(n.toString())){
                return n;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid type of PET: %s",description));
    }

    public String getDescription(){
        return this.description;
    }
}
