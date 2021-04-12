package edu.utn.adoptAPPet.service;

import edu.utn.adoptAPPet.model.Owner;
import edu.utn.adoptAPPet.model.Pet;
import edu.utn.adoptAPPet.repository.OwnerRepository;
import edu.utn.adoptAPPet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class OwnerService {

    private OwnerRepository ownerRepo;
    private PetRepository petRepo;

    @Autowired
    public OwnerService(OwnerRepository ownerRepo, PetRepository petRepo){
        this.ownerRepo = ownerRepo;
        this.petRepo = petRepo;
    }

    public void add(Owner owner){
        this.ownerRepo.save(owner);
    }

    public Owner findById(Long ownerId){
        return this.ownerRepo.findById(ownerId)
                .orElseThrow( () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Owner> getAll(){
        return this.ownerRepo.findAll();
    }


    public void deleteById(Long ownerId){
        this.ownerRepo.deleteById(ownerId);
    }

    public void update(Owner owner){
        // IMPLEMENTAR

    }

    public void addPet(Long ownerId, Integer petId){
        Owner existent = findById(ownerId);
        existent.getAdoptedPets().add(this.petRepo.getOne(petId));
        add(existent);
    }

    public void addPetToOwner(Long ownerId, Integer petId) {
        Pet pet = this.petRepo.getOne(petId);
        Owner owner = this.ownerRepo.getOne(ownerId);
        owner.getAdoptedPets().add(pet);
        this.ownerRepo.save(owner);
    }
}
