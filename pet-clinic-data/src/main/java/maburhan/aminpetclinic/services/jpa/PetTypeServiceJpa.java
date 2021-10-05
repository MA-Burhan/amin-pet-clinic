package maburhan.aminpetclinic.services.jpa;

import maburhan.aminpetclinic.model.PetType;
import maburhan.aminpetclinic.repositories.PetTypeRepository;
import maburhan.aminpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetTypeServiceJpa extends AbstractJpaService<PetType, Long, PetTypeRepository> implements PetTypeService {

    public PetTypeServiceJpa(PetTypeRepository repository) {
        super(repository);
    }
}
