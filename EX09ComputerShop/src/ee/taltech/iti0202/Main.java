package ee.taltech.iti0202;

import static ee.taltech.iti0202.Order.PURPOSE.GAMING;
import static ee.taltech.iti0202.Order.PURPOSE.NONE;
import static ee.taltech.iti0202.Order.PURPOSE.WORKSTATION;

import ee.taltech.iti0202.components.HDD;
import ee.taltech.iti0202.components.Motherboard;
import ee.taltech.iti0202.components.PSU;
import ee.taltech.iti0202.components.RAM;
import ee.taltech.iti0202.components.Processor;
import ee.taltech.iti0202.components.GraphicsCard;

public class Main {

    public static void main(String[] args) {
        ComputerShop Klick = new ComputerShop();
        PSU psu1 = new PSU("SilentiumPC PSU", 90, 80, 600);
        PSU psu2 = new PSU("Cooler Master", 100, 80, 600);
        PSU psu3 = new PSU("SeaSonic PRIME 550W", 110, 80, 600);

        HDD hdd1 = new HDD("Dell Server 1TB", 90, 30, 170, "SATA");
        HDD hdd2 = new HDD("Lenovo ThinkServer 1TB", 100, 30, 180, "SATA");
        HDD hdd3 = new HDD("Seagate Enterprise 2TB", 110, 30, 190, "SATA");

        RAM ram1 = new RAM("MicroMemory 8GB", 100, 50, 100, "DDR");
        RAM ram2 = new RAM("Fujitsu DDR4 8 GB", 110, 50, 100, "DDR");
        RAM ram3 = new RAM("Kingston DDR4 16GB", 120, 50, 100, "DDR");

        Processor cpu1 = new Processor("Intel", 240, 150, 100, "AGG");
        Processor cpu2 = new Processor("Intel", 270, 150, 100, "AGG");
        Processor cpu3 = new Processor("Intel", 300, 150, 100, "AGG");

        GraphicsCard gpu1 = new GraphicsCard("Nvidia", 200, 140, 90, "LGV");
        GraphicsCard gpu2 = new GraphicsCard("MSI", 210, 150, 100, "LGV");
        GraphicsCard gpu3 = new GraphicsCard("Asus", 220, 160, 110, "LGV");

        Motherboard motherboard1 = new Motherboard("Intel Biostar", 200, 250, 100,
                "AGG", "DDR", "LGV", "SATA");

        Motherboard motherboard2 = new Motherboard("Fujitsu Thin Mini-ITX", 220, 250, 100,
                "AGG", "DDR", "LGV", "SATA");

        Motherboard motherboard3 = new Motherboard("Asus STRIX GAMING", 150, 250, 100,
                "AGG", "DDR", "LGV", "SATA");

        Klick.addComponent(gpu1);
        Klick.addComponent(gpu2);
        Klick.addComponent(gpu3);
        Klick.addComponent(psu1);
        Klick.addComponent(psu2);
        Klick.addComponent(psu3);
        Klick.addComponent(cpu1);
        Klick.addComponent(cpu2);
        Klick.addComponent(cpu3);
        Klick.addComponent(ram1);
        Klick.addComponent(ram2);
        Klick.addComponent(ram3);
        Klick.addComponent(hdd1);
        Klick.addComponent(hdd2);
        Klick.addComponent(hdd3);
        Klick.addComponent(motherboard1);
        Klick.addComponent(motherboard2);
        Klick.addComponent(motherboard3);

        Order order1 = new Order(1000, GAMING);
        Order order2 = new Order(1500, WORKSTATION);
        Order order3 = new Order(1000, NONE);

//        Klick.makeOrder(order1);
//        Klick.makeOrder(order2);
        Klick.makeOrder(order3);
    }
}