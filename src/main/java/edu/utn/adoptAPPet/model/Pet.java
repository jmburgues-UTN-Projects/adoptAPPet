package edu.utn.adoptAPPet.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "petType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Cat.class, name = "CAT"),
        @JsonSubTypes.Type(value = Dog.class, name = "DOG")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pet {
    @Id
    private Integer petId;
    private String name;
    private String gender;
    @ManyToMany
    @JoinTable(
            name = "Pets_per_Vaccines",
            joinColumns = {@JoinColumn(name = "pet_id")},
            inverseJoinColumns = {@JoinColumn (name = "vaccine_id")}
    )
    private List<Vaccine> recordBook;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract PetType petType();
}
