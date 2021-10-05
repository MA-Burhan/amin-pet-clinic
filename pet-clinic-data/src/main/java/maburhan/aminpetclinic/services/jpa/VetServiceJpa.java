package maburhan.aminpetclinic.services.jpa;

import maburhan.aminpetclinic.model.Vet;
import maburhan.aminpetclinic.repositories.VetRepository;
import maburhan.aminpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VetServiceJpa extends AbstractJpaService<Vet, Long, VetRepository> implements VetService {

    public VetServiceJpa(VetRepository repository) {
        super(repository);
    }
}
