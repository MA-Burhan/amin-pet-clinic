package maburhan.aminpetclinic.repositories.map;

import maburhan.aminpetclinic.model.Owner;

import java.util.Optional;

public interface OwnerMapRepository extends CrudMapRepository<Owner, Long>{

    Optional<Owner> findByLastName(String lastName);
}
