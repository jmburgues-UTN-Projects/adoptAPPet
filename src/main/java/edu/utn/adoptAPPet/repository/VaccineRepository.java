package edu.utn.adoptAPPet.repository;

import edu.utn.adoptAPPet.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine,Integer> {
}
