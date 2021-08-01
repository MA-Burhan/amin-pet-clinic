package maburhan.aminpetclinic.services.map;

import org.springframework.stereotype.Service;
import maburhan.aminpetclinic.model.Pet;
import maburhan.aminpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {

}
