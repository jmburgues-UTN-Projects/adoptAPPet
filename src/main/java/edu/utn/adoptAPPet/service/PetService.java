package edu.utn.adoptAPPet.service;

import edu.utn.adoptAPPet.model.Pet;
import edu.utn.adoptAPPet.model.Vaccine;
import edu.utn.adoptAPPet.repository.PetRepository;
import edu.utn.adoptAPPet.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PetService {
    private PetRepository petRepo;
    private VaccineRepository vaccineRepo;

    @Autowired
    public PetService(PetRepository petRepo, VaccineRepository vaccineRepo) {
        this.petRepo = petRepo;
        this.vaccineRepo = vaccineRepo;
    }

    public void add(Pet pet){
        this.petRepo.save(pet);
    }

    public Pet findById(Integer petId){
        return this.petRepo.findById(petId)
         .orElseThrow( () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Pet> getAll(){
        return this.petRepo.findAll();
    }

    public void deleteById(Integer petId){
        this.petRepo.deleteById(petId);
    }

    public void update(Pet pet){
        // COMPELTAR
    }

    public void addVaccineToPet(Integer petId,Integer vaccineId){
        Pet pet = findById(petId);
        pet.getRecordBook().add(this.vaccineRepo.getOne(vaccineId));
        add(pet);
    }

}
