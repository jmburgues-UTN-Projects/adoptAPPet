package edu.utn.adoptAPPet.service;

import edu.utn.adoptAPPet.model.Vaccine;
import edu.utn.adoptAPPet.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class VaccineService {

    @Autowired
    private VaccineRepository vaccineRepo;

    public void add(Vaccine vaccine){
        this.vaccineRepo.save(vaccine);
    }

    public Vaccine findById(Integer vaccineId){
        return this.vaccineRepo.findById(vaccineId)
                .orElseThrow( () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Vaccine> getAll(){
        return this.vaccineRepo.findAll();
    }

    public void deleteById(Integer vaccineId){
        this.vaccineRepo.deleteById(vaccineId);
    }

    public void update(Vaccine vaccine){
        // IMPLEMENTAR
    }
}
