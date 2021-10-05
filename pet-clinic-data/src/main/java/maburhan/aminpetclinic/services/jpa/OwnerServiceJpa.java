package maburhan.aminpetclinic.services.jpa;

import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.repositories.OwnerRepository;
import maburhan.aminpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class OwnerServiceJpa extends AbstractJpaService<Owner, Long, OwnerRepository> implements OwnerService {

    public OwnerServiceJpa(OwnerRepository repository) {
        super(repository);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return repository.findByLastName(lastName).orElse(null);
    }

}
