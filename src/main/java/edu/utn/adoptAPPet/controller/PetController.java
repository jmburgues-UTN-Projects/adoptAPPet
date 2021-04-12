package edu.utn.adoptAPPet.controller;

import edu.utn.adoptAPPet.model.Pet;
import edu.utn.adoptAPPet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAll(){
        return petService.getAll();
    }

    @GetMapping("/{id}")
    public Pet getById(@PathVariable Integer id){
        return this.petService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody Pet pet){
        this.petService.add(pet);
    }

    @PutMapping
    public void update(@RequestBody Pet pet){
        this.petService.update(pet); // FALTA IMPLEMENTAR EN REPO.
    }

    @DeleteMapping("/{id")
    public void delete(@PathVariable Integer id){
        this.petService.deleteById(id);
    }

    @PutMapping("/{petId}/vaccine/{vaccineId}")
    public void addVaccineToPet(@PathVariable Integer petId, @PathVariable Integer vaccineId){
        this.petService.addVaccineToPet(petId,vaccineId);
    }
}
