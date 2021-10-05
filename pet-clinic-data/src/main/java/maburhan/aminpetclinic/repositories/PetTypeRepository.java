package maburhan.aminpetclinic.repositories;

import maburhan.aminpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
