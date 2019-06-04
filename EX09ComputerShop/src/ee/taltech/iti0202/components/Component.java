package ee.taltech.iti0202.components;

public abstract class Component {
    private String name;
    private int price;
    private int capacity;
    private int consumption;

    public Component(String name, int price, int capacity, int consumption) {
        this.price = price;
        this.capacity = capacity;
        this.consumption = consumption;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getConsumption() {
        return consumption;
    }
}
