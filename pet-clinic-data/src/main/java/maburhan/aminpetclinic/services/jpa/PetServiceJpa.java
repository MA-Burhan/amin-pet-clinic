package maburhan.aminpetclinic.services.jpa;

import maburhan.aminpetclinic.model.Pet;
import maburhan.aminpetclinic.repositories.PetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetServiceJpa extends AbstractJpaService<Pet, Long, PetRepository> {

    public PetServiceJpa(PetRepository repository) {
        super(repository);
    }
}
