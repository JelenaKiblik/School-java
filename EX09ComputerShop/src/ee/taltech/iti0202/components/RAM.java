package ee.taltech.iti0202.components;

public class RAM extends Component {

    private String socket;

    public RAM(String name, int price, int capacity, int consumption) {
        super(name, price, capacity, consumption);
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }

}
