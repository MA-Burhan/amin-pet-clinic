package se.aminburhan.aminpetclinic.services.map;

import org.springframework.stereotype.Service;
import se.aminburhan.aminpetclinic.model.Pet;
import se.aminburhan.aminpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {

}
