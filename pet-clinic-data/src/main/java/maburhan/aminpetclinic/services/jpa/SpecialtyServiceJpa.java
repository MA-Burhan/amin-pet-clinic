package maburhan.aminpetclinic.services.jpa;

import maburhan.aminpetclinic.model.Specialty;
import maburhan.aminpetclinic.repositories.SpecialtyRepository;
import maburhan.aminpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class SpecialtyServiceJpa extends AbstractJpaService<Specialty, Long, SpecialtyRepository> implements SpecialtyService {

    public SpecialtyServiceJpa(SpecialtyRepository repository) {
        super(repository);
    }
}
