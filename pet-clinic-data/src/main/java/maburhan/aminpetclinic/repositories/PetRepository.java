package maburhan.aminpetclinic.repositories;

import maburhan.aminpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
