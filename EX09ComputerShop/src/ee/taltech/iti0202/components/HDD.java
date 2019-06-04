package ee.taltech.iti0202.components;

public class HDD extends Component {

    private String socket;

    public HDD(String name, int price, int capacity, int consumption) {
        super(name, price, capacity, consumption);
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }
}
