package maburhan.aminpetclinic.bootstrap;

import com.github.javafaker.Faker;
import maburhan.aminpetclinic.model.*;
import maburhan.aminpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(ownerService.findAll().isEmpty()) {
            loadData();
        }

    }

    private void loadData() {
        /* Create and load Pet types */
        PetType dog = new PetType();
        dog.setName("dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        petTypeService.save(cat);

        System.out.println("Loaded Pet Types....");


        /* Create and load Owners */
        Faker faker = new Faker(Locale.UK);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Owner owner = new Owner();
            owner.setFirstName(faker.name().firstName());
            owner.setLastName(faker.name().lastName());
            owner.setAddress(faker.address().streetAddress());
            owner.setCity(faker.address().city());
            owner.setTelephone(faker.phoneNumber().cellPhone());

                /* Create and load Pets */
                Pet pet = new Pet();
                pet.setPetType(random.nextBoolean() ? cat : dog);
                pet.setOwner(owner);
                pet.setBirthDate(LocalDate.now().minusDays(random.nextInt(3600)));
                String petName = pet.getPetType() == cat ? faker.cat().name() : faker.dog().name();
                pet.setName(petName);

                    /* Create visit for pet */
                    Visit visit = new Visit();
                    visit.setPet(pet);
                    visit.setDescription(faker.medical().symptoms());
                    visit.setDate(LocalDate.now().plusDays(random.nextInt(90)));

                pet.addVisit(visit);

            owner.addPet(pet);
            ownerService.save(owner);
        }

        System.out.println("Loaded Owners....");

        /* Create and load specialties */
        Specialty radiology = new Specialty();
        radiology.setName("radiology");
        specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setName("surgery");
        specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setName("dentistry");
        specialtyService.save(dentistry);

        System.out.println("Loaded specialties....");

        /* Create and load vets */
        for (int i = 0; i < 10; i++) {
            Vet vet = new Vet();
            vet.setFirstName(faker.name().firstName());
            vet.setLastName(faker.name().firstName());

            int rand = random.nextInt(3);
            Specialty specialty = null;
            switch(rand){
                case 0:
                    specialty = radiology;
                    break;
                case 1:
                    specialty = surgery;
                    break;
                case 2:
                    specialty = dentistry;
                    break;
            }
            vet.addSpecialty(specialty);

            vetService.save(vet);
        }

        System.out.println("Loaded Vets....");
    }
}
