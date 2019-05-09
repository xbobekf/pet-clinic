package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Duro");
        owner1.setLastname("Killer");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstname("Magda");
        owner2.setLastname("Sexmachine");

        ownerService.save(owner2);

        System.out.println("Loaded owners..........");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstname("Kunda");
        vet1.setLastname("Rozjebana");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstname("Kokot");
        vet2.setLastname("Povednuty");

        vetService.save(vet2);

        System.out.println("Icte vsetci do PICE!!! :P");


    }
}
