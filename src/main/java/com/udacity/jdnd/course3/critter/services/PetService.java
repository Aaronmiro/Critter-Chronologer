package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Aaron
 * @date 3/25/22 12:16 PM
 */
@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet getById(long petId) {
        return petRepository.getOne(petId);
    }

    public List<Pet> getByOwnerId(long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }

    public List<Long> getIdsByOwnerId(long ownerId){
        return petRepository.findAllIdsByOwnerId(ownerId);
    }

    public List<Pet> getAll() {
        return petRepository.findAll();
    }

//    public List<Long> getIdsByScheduleId(long scheduleId) {
//        List<Long> allByScheduleId = petRepository.findAllByScheduleId(scheduleId);
//        return allByScheduleId;
//    }
}
