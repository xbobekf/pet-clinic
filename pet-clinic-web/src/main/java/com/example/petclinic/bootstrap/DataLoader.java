package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.PetType;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.VetService;
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
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstname("Duro");
        owner1.setLastname("Killer");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Magda");
        owner2.setLastname("Sexmachine");

        ownerService.save(owner2);

        System.out.println("Loaded owners..........");

        Vet vet1 = new Vet();
        vet1.setFirstname("Bozena");
        vet1.setLastname("Kozata");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("John");
        vet2.setLastname("Snow");

        vetService.save(vet2);

        System.out.println("This is spartaaa!!! :P");


    }
}
