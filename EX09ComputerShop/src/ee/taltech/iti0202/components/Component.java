package ee.taltech.iti0202.components;

public abstract class Component {
    private String name;
    private int price;
    private int performance;
    private int consumption;

    public Component(String name, int price, int performance, int consumption) {
        this.price = price;
        this.performance = performance;
        this.consumption = consumption;
        this.name = name;
    }

    public String getName() {
        return name;
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
}
