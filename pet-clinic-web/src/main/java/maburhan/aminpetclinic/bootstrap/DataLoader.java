package maburhan.aminpetclinic.bootstrap;

import com.github.javafaker.Faker;
import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.model.PetType;
import maburhan.aminpetclinic.model.Vet;
import maburhan.aminpetclinic.services.OwnerService;
import maburhan.aminpetclinic.services.PetTypeService;
import maburhan.aminpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat = petTypeService.save(cat);

        System.out.println("Loaded Pet Types....");

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
