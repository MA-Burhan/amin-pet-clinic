package se.aminburhan.aminpetclinic.services;

import se.aminburhan.aminpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
