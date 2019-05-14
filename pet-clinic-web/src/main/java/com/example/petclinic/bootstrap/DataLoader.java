package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.SpecialityService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
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
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstname("Duro");
        owner1.setLastname("Killer");
        owner1.setAddress("123 Street");
        owner1.setCity("Hell");
        owner1.setTelephone("1231231233");

        ownerService.save(owner1);

        Pet durosPet = new Pet();
        durosPet.setPetType(savedDogPetType);
        durosPet.setOwner(owner1);
        durosPet.setBirthDate(LocalDate.now());
        durosPet.setName("Galaktus");

        owner1.getPets().add(durosPet);


        Owner owner2 = new Owner();
        owner2.setFirstname("Magda");
        owner2.setLastname("Sexmachine");
        owner2.setAddress("123 Street");
        owner2.setCity("Hell");
        owner2.setTelephone("1231231233");

        ownerService.save(owner2);

        Pet magdasPet = new Pet();
        magdasPet.setPetType(savedCatPetType);
        magdasPet.setOwner(owner1);
        magdasPet.setBirthDate(LocalDate.now());
        magdasPet.setName("Smaker");

        owner2.getPets().add(magdasPet);

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
        vet1.setFirstname("Bozena");
        vet1.setLastname("Kozata");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("John");
        vet2.setLastname("Snow");
        vet2.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("This is spartaaa!!! :P");
    }
}
