package ee.taltech.iti0202;

import static ee.taltech.iti0202.Order.PURPOSE.GAMING;
import static ee.taltech.iti0202.Order.PURPOSE.WORKSTATION;

import ee.taltech.iti0202.components.Component;
import ee.taltech.iti0202.components.HDD;
import ee.taltech.iti0202.components.Motherboard;
import ee.taltech.iti0202.components.PSU;
import ee.taltech.iti0202.components.RAM;
import ee.taltech.iti0202.components.Processor;
import ee.taltech.iti0202.components.GraphicsCard;
import java.util.ArrayList;
import java.util.List;

public class ComputerShop {
    private List<RAM> ramList = new ArrayList<>();
    private List<GraphicsCard> graphicsCardList = new ArrayList<>();
    private List<Processor> processorList = new ArrayList<>();
    private List<HDD> hddList = new ArrayList<>();
    private List<Motherboard> motherboardList = new ArrayList<>();
    private List<PSU> psuList = new ArrayList<>();
    private List<Computer> computers = new ArrayList<>();
    private List<Component> components = new ArrayList<>();
    private Computer bestChoice = null;

    public void addComponent(Component component) {
        components.add(component);
    }

    public void addComponentToList() {
        for (Component component : components) {
            if (component instanceof RAM) {
                ramList.add(((RAM) component));
            } else if (component instanceof GraphicsCard) {
                graphicsCardList.add(((GraphicsCard) component));
            } else if (component instanceof Processor) {
                processorList.add(((Processor) component));
            } else if (component instanceof HDD) {
                hddList.add(((HDD) component));
            } else if (component instanceof Motherboard) {
                motherboardList.add(((Motherboard) component));
            } else {
                psuList.add(((PSU) component));
            }
        }
    }

    public void addComputerToList(Computer computer) {
        computers.add(computer);
    }

    public void makeComputers() {
        addComponentToList();
        for (Motherboard motherboard : motherboardList) {
            for (PSU psu : psuList) {
                for (GraphicsCard gpu : graphicsCardList) {
                    for (HDD hdd : hddList) {
                        for (RAM ram : ramList) {
                            for (Processor cpu : processorList) {
                                Computer computer = new Computer(cpu, gpu, hdd, motherboard, ram, psu);
                                addComputerToList(computer);
                            }
                        }
                    }
                }
            }
        }
    }

    public void makeOrder(Order order) {
        makeComputers();
        int performance = 0;
        List<Computer> unsuitableComputers = new ArrayList<>();

        for (Computer computer : computers) {
            if ((order.getCost() != -1 && computer.getPrice() > order.getCost())
                    || computer.getConsumption() > computer.getPsu().getConsumption()) {
                unsuitableComputers.add(computer);
            }
            if (!computer.getMotherboard().getProcessorSocket().equals(computer.getProcessor().getSocket())) {
                unsuitableComputers.add(computer);
            }
            if (!computer.getMotherboard().getGraphicsCardSocket().equals(computer.getGraphicsCard().getSocket())) {
                unsuitableComputers.add(computer);
            }
            if (!computer.getMotherboard().getRamSocket().equals(computer.getRam().getSocket())) {
                unsuitableComputers.add(computer);
            }
            if (!computer.getMotherboard().getHddSocket().equals(computer.getHdd().getSocket())) {
                unsuitableComputers.add(computer);
            }
        }

        computers.removeAll(unsuitableComputers);
        for (Computer computer : computers) {
            if (order.getPurpose().equals(GAMING)) {
                computer.setGpuPerformanceBonus(2);
            }
            if (order.getPurpose().equals(WORKSTATION)) {
                computer.setCpuPerformanceBonus(2);
            }
            if (computer.getPerformance() > performance) {
                performance = computer.getPerformance();
                bestChoice = computer;
            }
        }
        if (bestChoice == null) {
            System.out.println("Not enough components to order.");
        } else {
            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        return String.format("Your order is ready: price %d, performance %d(Graphic card - %s, Processor - %s, "
                        + "Memory - %s, Motherboard - %s, Hard drive - %s, Power supply unit - %s).", bestChoice.getPrice(),
                bestChoice.getPerformance(), bestChoice.getGraphicsCard().getName(), bestChoice.getProcessor().getName(),
                bestChoice.getMotherboard().getName(), bestChoice.getRam().getName(),
                bestChoice.getHdd().getName(), bestChoice.getPsu().getName());
    }
}
