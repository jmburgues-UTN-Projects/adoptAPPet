package edu.utn.adoptAPPet.controller;

import edu.utn.adoptAPPet.model.Owner;
import edu.utn.adoptAPPet.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<Owner> getAll(){
        return this.ownerService.getAll();
    }

    @GetMapping("/{id}")
    public Owner getById(@PathVariable Long ownerId){
        return this.ownerService.findById(ownerId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long ownerId){
        this.ownerService.deleteById(ownerId);
    }

    @PostMapping
    public void add(@RequestBody Owner owner){
        this.ownerService.add(owner);
    }

    @PutMapping
    public void update(@RequestBody Owner owner){
        this.ownerService.update(owner);
    }

    @PutMapping("/{ownerId}/pet/{petId}")
    public void addPetToOwner(@PathVariable Long ownerId, @PathVariable Integer petId){
        this.ownerService.addPetToOwner(ownerId,petId);
    }



}
