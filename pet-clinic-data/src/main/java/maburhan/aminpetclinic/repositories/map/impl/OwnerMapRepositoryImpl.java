package maburhan.aminpetclinic.repositories.map.impl;

import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.repositories.map.OwnerMapRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OwnerMapRepositoryImpl extends AbstractMapRepository<Owner> implements OwnerMapRepository {

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        for (Owner owner : map.values()) {
            if (owner.getLastName().equalsIgnoreCase(lastName)) {
                return Optional.of(owner);
            }
        }
        return Optional.empty();
    }
}
