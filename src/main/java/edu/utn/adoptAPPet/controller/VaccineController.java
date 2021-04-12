package edu.utn.adoptAPPet.controller;

import edu.utn.adoptAPPet.model.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.utn.adoptAPPet.service.VaccineService;

import java.util.List;


@RestController
@RequestMapping("/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping
    public List<Vaccine> getAll(){
        return this.vaccineService.getAll();
    }

    @GetMapping("/{id}")
    public Vaccine getById(@PathVariable Integer vaccineId){
        return this.vaccineService.findById(vaccineId);
    }

    @PostMapping
    public void add(@RequestBody Vaccine oneVaccine){
        this.vaccineService.add(oneVaccine);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer vaccineId){
        this.vaccineService.deleteById(vaccineId);
    }
}
