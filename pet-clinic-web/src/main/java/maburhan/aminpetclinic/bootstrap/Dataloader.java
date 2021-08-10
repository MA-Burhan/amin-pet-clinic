package maburhan.aminpetclinic.bootstrap;

import com.github.javafaker.Faker;
import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.model.Vet;
import maburhan.aminpetclinic.services.OwnerService;
import maburhan.aminpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            Owner owner = new Owner();
            owner.setFirstName(faker.name().firstName());
            owner.setLastName(faker.name().lastName());
            ownerService.save(owner);
        }

        System.out.println("Loaded Owners....");

        for (int i = 0; i < 10; i++) {
            Vet vet = new Vet();
            vet.setFirstName(faker.name().firstName());
            vet.setLastName(faker.name().firstName());
            vetService.save(vet);
        }

        System.out.println("Loaded Vets....");

    }
}
