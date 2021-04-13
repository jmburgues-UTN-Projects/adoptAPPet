package edu.utn.adoptAPPet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNumber;
    @NotNull(message = "Owner's name is required.")
    private String name;
    private String adress;
    private String phoneNumber;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private List<Pet> adoptedPets;
}
