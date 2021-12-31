package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.repositories.map.OwnerMapRepository;
import maburhan.aminpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class OwnerServiceMap extends AbstractMapService<Owner, Long, OwnerMapRepository> implements OwnerService {

    public OwnerServiceMap(OwnerMapRepository repository) {
        super(repository);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return repository.findByLastName(lastName).orElse(null);
    }
}
