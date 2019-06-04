package ee.taltech.iti0202.components;

public class HDD extends Component {
    private String socket;

    public HDD(String name, int price, int performance, int consumption, String socket) {
        super(name, price, performance, consumption);
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }
}
