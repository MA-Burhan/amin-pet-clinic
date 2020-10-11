package se.aminburhan.aminpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.aminburhan.aminpetclinic.model.Owner;
import se.aminburhan.aminpetclinic.model.Vet;
import se.aminburhan.aminpetclinic.services.OwnerService;
import se.aminburhan.aminpetclinic.services.VetService;
import se.aminburhan.aminpetclinic.services.map.OwnerServiceMap;
import se.aminburhan.aminpetclinic.services.map.VetServiceMap;

@Component
public class Dataloader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public Dataloader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Lionel");
        owner1.setLastName("Messi");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Cristiano");
        owner2.setLastName("Ronaldo");
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("LeBron");
        vet1.setLastName("James");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jimmy");
        vet2.setLastName("Buttler");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
