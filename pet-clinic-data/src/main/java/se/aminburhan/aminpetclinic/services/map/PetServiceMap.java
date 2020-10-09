package se.aminburhan.aminpetclinic.services.map;

import se.aminburhan.aminpetclinic.model.Pet;
import se.aminburhan.aminpetclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet object) {
        return map.put(object.getId(), object);
    }
}
