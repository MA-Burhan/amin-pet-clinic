package maburhan.aminpetclinic.services.map;

import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.repositories.map.OwnerMapRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceMapTest {

    @Mock
    OwnerMapRepository repository;

    OwnerServiceMap service;
    Owner owner;
    final Long ownerId = 1L;
    final String lastName= "Doe";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new OwnerServiceMap(repository);
        owner = Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(owner);

        when(repository.findAll()).thenReturn(ownerSet);

        Set<Owner> returnOwners = service.findAll();

        assertNotNull(returnOwners);
        assertEquals(1, returnOwners.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(repository.findById(eq(ownerId))).thenReturn(owner);

        Owner returnOwner = service.findById(ownerId);

        assertNotNull(returnOwner);
        assertEquals(owner, returnOwner);
    }

    @Test
    void findByIdNotFound() {
        when(repository.findById(anyLong())).thenReturn(null);

        Owner returnOwner = service.findById(21L);

        assertNull(returnOwner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().lastName(lastName).build();

        when(repository.save(eq(ownerToSave))).thenReturn(owner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
        assertEquals(owner, savedOwner);
    }

    @Test
    void delete() {
        service.delete(owner);

        verify(repository, times(1)).delete(eq(owner));
    }

    @Test
    void deleteById() {
        service.deleteById(ownerId);

        verify(repository, times(1)).deleteById(eq(ownerId));
    }

    @Test
    void findByLastName() {
        when(repository.findByLastName(any())).thenReturn(Optional.of(owner));

        Owner doe = service.findByLastName(lastName);

        assertEquals(owner, doe);
        verify(repository, times(1)).findByLastName(any());
    }


}