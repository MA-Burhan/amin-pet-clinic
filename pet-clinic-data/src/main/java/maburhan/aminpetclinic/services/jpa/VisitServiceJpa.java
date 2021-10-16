package maburhan.aminpetclinic.services.jpa;

import maburhan.aminpetclinic.model.Visit;
import maburhan.aminpetclinic.repositories.VisitRepository;
import maburhan.aminpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VisitServiceJpa extends AbstractJpaService<Visit, Long, VisitRepository> implements VisitService {

    public VisitServiceJpa(VisitRepository repository) {
        super(repository);
    }
}
