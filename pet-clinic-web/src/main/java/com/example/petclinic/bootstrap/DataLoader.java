package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int cunt =petTypeService.findAll().size();

        if (cunt == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Duro");
        owner1.setLastName("Killer");
        owner1.setAddress("1234 Street");
        owner1.setCity("Hell");
        owner1.setTelephone("1231231233");


        Pet durosPet = new Pet();
        durosPet.setPetType(savedDogPetType);
        durosPet.setOwner(owner1);
        durosPet.setBirthDate(LocalDate.now());
        durosPet.setName("Galaktus");

        owner1.getPets().add(durosPet);
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Magda");
        owner2.setLastName("Sexmachine");
        owner2.setAddress("123 Street");
        owner2.setCity("Hell");
        owner2.setTelephone("1231231233");


        Pet magdasPet = new Pet();
        magdasPet.setPetType(savedCatPetType);
        magdasPet.setOwner(owner2);
        magdasPet.setBirthDate(LocalDate.now());
        magdasPet.setName("Smaker");

        owner2.getPets().add(magdasPet);

        ownerService.save(owner2);

        Visit catVisit= new Visit();
        catVisit.setPet(magdasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Farting Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded owners..........");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);


        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Vet vet1 = new Vet();
        vet1.setFirstName("Bozena");
        vet1.setLastName("Kozata");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Snow");
        vet2.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("This is spartaaa!!! :P");
    }
}
