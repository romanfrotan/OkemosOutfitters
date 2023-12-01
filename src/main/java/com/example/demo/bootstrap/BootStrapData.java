package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {
    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;
    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }
    @Override
    public void run(String... args) throws Exception {


        //To add sample Inventory

        if(outsourcedPartRepository.count()==0) {
            OutsourcedPart rod = new OutsourcedPart();
            rod.setCompanyName("Nomad Anglers");
            rod.setName("Spin Reel");
            rod.setInv(5);
            rod.setPrice(20.0);
            rod.setId(100L);
            rod.setMaxInventory(10);
            rod.setMinInventory(2);
            outsourcedPartRepository.save(rod);

            OutsourcedPart flyReel = new OutsourcedPart();
            flyReel.setCompanyName("FishUSA");
            flyReel.setName("Fly Reel");
            flyReel.setInv(5);
            flyReel.setPrice(35.0);
            flyReel.setId(100L);
            flyReel.setMaxInventory(15);
            flyReel.setMinInventory(1);
            outsourcedPartRepository.save(flyReel);


            OutsourcedPart trollReel = new OutsourcedPart();
            trollReel.setCompanyName("Nomad Anglers");
            trollReel.setName("Trolling Reel");
            trollReel.setInv(5);
            trollReel.setPrice(45.0);
            trollReel.setId(100L);
            trollReel.setMinInventory(3);
            trollReel.setMaxInventory(10);
            outsourcedPartRepository.save(trollReel);

            OutsourcedPart baitCasterReel = new OutsourcedPart();
            baitCasterReel.setCompanyName("FishUSA");
            baitCasterReel.setName("Baitcaster Reel");
            baitCasterReel.setInv(5);
            baitCasterReel.setPrice(25.0);
            baitCasterReel.setId(100L);
            baitCasterReel.setMinInventory(1);
            baitCasterReel.setMaxInventory(8);
            outsourcedPartRepository.save(baitCasterReel);

            OutsourcedPart kidsReel = new OutsourcedPart();
            kidsReel.setCompanyName("Okuma");
            kidsReel.setName("Kid's Reel");
            kidsReel.setInv(5);
            kidsReel.setPrice(15.0);
            kidsReel.setId(100L);
            kidsReel.setMinInventory(1);
            kidsReel.setMaxInventory(7);
            outsourcedPartRepository.save(kidsReel);
        }

        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts) {
            if (part.getName().equals("Kid's Reel")) thePart = part;
            if (part.getName().equals("Spin Reel")) thePart = part;
            if (part.getName().equals("Trolling Reel")) thePart = part;
            if (part.getName().equals("Fly Reel")) thePart = part;
            if (part.getName().equals("Baitcaster Reel")) thePart = part;
        }

        System.out.println(thePart.getCompanyName());

        if(productRepository.count()==0) {
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            Product flyRod = new Product("Fly rod", 100.0, 15);
            Product spinRod = new Product("Spin rod", 100.0, 15);
            Product baitCaster = new Product("Bait Caster rod", 100.0, 15);
            Product trollingRod = new Product("Trolling rod", 100.0, 15);
            Product kidsRod = new Product("Kid's rod", 100.0, 15);
            productRepository.save(flyRod);
            productRepository.save(spinRod);
            productRepository.save(baitCaster);
            productRepository.save(trollingRod);
            productRepository.save(kidsRod);
        }
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());
    }
}