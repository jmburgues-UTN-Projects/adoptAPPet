package edu.utn.adoptAPPet.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
public class Vaccine {
    @Id
    private Integer vaccineId;
    private String name;
    @ManyToMany(mappedBy = "recordBook", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Pet> appliedTo;
}
