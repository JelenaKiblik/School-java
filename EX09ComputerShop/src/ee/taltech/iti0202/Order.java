package ee.taltech.iti0202;

public class Order {
    private int cost;
    private PURPOSE purpose;

    public enum PURPOSE {
        GAMING, WORKSTATION, NONE
    }

    public Order(int cost, PURPOSE purpose) {
        this.cost = cost;
        this.purpose = purpose;
    }

    public Order(int cost) {
        this(cost, PURPOSE.NONE);
    }

    public Order(PURPOSE purpose) {
        this(-1, purpose);
    }

    public Order() {
        this(-1, PURPOSE.NONE);
    }

    public int getCost() {
        return cost;
    }

    public PURPOSE getPurpose() {
        return purpose;
    }
}
