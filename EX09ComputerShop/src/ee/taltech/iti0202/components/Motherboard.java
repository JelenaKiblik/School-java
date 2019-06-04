package ee.taltech.iti0202.components;

public class Motherboard extends Component {
    public String hddSocket;
    public String ramSocket;
    public String processorSocket;
    public String graphicsCardSocket;


    public Motherboard(String name, int price, int performance, int consumption, String processorSocket, String ramSocket,
                       String graphicsCardSocket, String hddSocket) {
        super(name, price, performance, consumption);
        this.hddSocket = hddSocket;
        this.ramSocket = ramSocket;
        this.processorSocket = processorSocket;
        this.graphicsCardSocket = graphicsCardSocket;
    }

    public String getRamSocket() {
        return ramSocket;
    }

    public String getHddSocket() {
        return hddSocket;
    }

    public String getProcessorSocket() {
        return processorSocket;
    }

    public String getGraphicsCardSocket() {
        return graphicsCardSocket;
    }
}
