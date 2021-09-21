package maburhan.aminpetclinic.bootstrap;

import com.github.javafaker.Faker;
import maburhan.aminpetclinic.model.Owner;
import maburhan.aminpetclinic.model.Pet;
import maburhan.aminpetclinic.model.PetType;
import maburhan.aminpetclinic.model.Vet;
import maburhan.aminpetclinic.services.OwnerService;
import maburhan.aminpetclinic.services.PetService;
import maburhan.aminpetclinic.services.PetTypeService;
import maburhan.aminpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        petTypeService.save(cat);

        System.out.println("Loaded Pet Types....");

        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Owner owner = new Owner();
            owner.setFirstName(faker.name().firstName());
            owner.setLastName(faker.name().lastName());
            owner.setAddress(faker.address().streetAddress());
            owner.setCity(faker.address().city());
            owner.setTelephone(faker.phoneNumber().cellPhone());

            Pet pet = new Pet();
            pet.setPetType(random.nextBoolean() ? cat : dog);
            pet.setOwner(owner);
            pet.setBirthDate(LocalDate.now().minusYears(random.nextInt(10)));
            pet.setName(faker.name().firstName());
            petService.save(pet);

            owner.addPet(pet);
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
