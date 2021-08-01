package maburhan.aminpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.model.Vet;
import maburhan.aminpetclinic.services.OwnerService;
import maburhan.aminpetclinic.services.VetService;

@Component
public class Dataloader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public Dataloader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Lionel");
        owner1.setLastName("Messi");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Cristiano");
        owner2.setLastName("Ronaldo");
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("LeBron");
        vet1.setLastName("James");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jimmy");
        vet2.setLastName("Buttler");
        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
