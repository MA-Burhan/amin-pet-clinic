package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Owner owner;
    final Long ownerId = 1L;
    final String lastName= "Doe";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap();
        owner = Owner.builder().id(ownerId).lastName(lastName).build();
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
        assertTrue(ownerSet.contains(owner));
    }

    @Test
    void findById() {
        Owner ownerResult = ownerServiceMap.findById(ownerId);

        assertEquals(owner, ownerResult);
    }

    @Test
    void saveOwnerWithExistingId() {
        Long id = 13L;
        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveOwnerWithNullId(){
        Owner savedOwner = ownerServiceMap.save(new Owner());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(owner);

        assertFalse(ownerServiceMap.findAll().contains(owner));
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertFalse(ownerServiceMap.findAll().contains(owner));
    }

    @Test
    void findByLastName() {
        Owner doe = ownerServiceMap.findByLastName(lastName);

        assertNotNull(doe);
        assertEquals(ownerId, doe.getId());
        assertEquals(lastName, doe.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner doe = ownerServiceMap.findByLastName("foo");

        assertNull(doe);
    }

}