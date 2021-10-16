package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.model.Pet;
import maburhan.aminpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {

}
