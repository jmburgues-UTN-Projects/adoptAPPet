package edu.utn.adoptAPPet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Owner {
    @Id
    private Long idNumber;
    private String name;
    private String adress;
    private String phoneNumber;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private List<Pet> adoptedPets;
}
