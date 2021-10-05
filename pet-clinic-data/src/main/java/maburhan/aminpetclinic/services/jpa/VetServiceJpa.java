package maburhan.aminpetclinic.services.jpa;

import maburhan.aminpetclinic.model.Vet;
import maburhan.aminpetclinic.repositories.VetRepository;

public class VetServiceJpa extends AbstractJpaService<Vet, Long, VetRepository> {

    public VetServiceJpa(VetRepository repository) {
        super(repository);
    }
}
