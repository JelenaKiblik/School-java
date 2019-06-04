package ee.taltech.iti0202.components;

public class GraphicsCard extends Component {

    private String socket;

    public GraphicsCard(String name, int price, int capacity, int consumption, String socket) {
        super(name, price, capacity, consumption);
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }
}
