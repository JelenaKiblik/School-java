package ee.taltech.iti0202;

import ee.taltech.iti0202.components.Processor;
import ee.taltech.iti0202.components.GraphicsCard;
import ee.taltech.iti0202.components.HDD;
import ee.taltech.iti0202.components.Motherboard;
import ee.taltech.iti0202.components.PSU;
import ee.taltech.iti0202.components.RAM;

public class Computer {
    private RAM ram;
    private PSU psu;
    private HDD hdd;
    private Processor processor;
    private Motherboard motherboard;
    private GraphicsCard graphicsCard;
    private int price;
    private int performance;
    private int consumption;
    private int gpuPerformanceBonus = 1;
    private int cpuPerformanceBonus = 1;

    public Computer(Processor processor, GraphicsCard graphicsCard, HDD hdd, Motherboard motherboard, RAM ram, PSU psu) {
        this.hdd = hdd;
        this.ram = ram;
        this.psu = psu;
        this.processor = processor;
        this.motherboard = motherboard;
        this.graphicsCard = graphicsCard;

        performance = processor.getPerformance() * cpuPerformanceBonus + graphicsCard.getPerformance() * gpuPerformanceBonus
                + hdd.getPerformance() + motherboard.getPerformance() + ram.getPerformance() + psu.getPerformance();
        consumption = processor.getConsumption() + graphicsCard.getConsumption() + hdd.getConsumption()
                + motherboard.getConsumption() + ram.getConsumption();
        price = processor.getPrice() + graphicsCard.getPrice() + hdd.getPrice() + motherboard.getPrice()
                + ram.getPrice() + psu.getPrice();
    }

    public void setGpuPerformanceBonus(int performanceBonus) {
        this.gpuPerformanceBonus = performanceBonus;
    }

    public void setCpuPerformanceBonus(int cpuPerformanceBonus) {
        this.cpuPerformanceBonus = cpuPerformanceBonus;
    }

    public int getPrice() {
        return price;
    }

    public int getPerformance() {
        return performance;
    }

    public int getConsumption() {
        return consumption;
    }

    public Processor getProcessor() {
        return processor;
    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    public HDD getHdd() {
        return hdd;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public RAM getRam() {
        return ram;
    }

    public PSU getPsu() {
        return psu;
    }
}
