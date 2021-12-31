package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.model.PetType;
import maburhan.aminpetclinic.repositories.map.PetTypeMapRepository;
import maburhan.aminpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class PetTypeServiceMap extends AbstractMapService<PetType, Long, PetTypeMapRepository> implements PetTypeService {

    public PetTypeServiceMap(PetTypeMapRepository repository) {
        super(repository);
    }
}
