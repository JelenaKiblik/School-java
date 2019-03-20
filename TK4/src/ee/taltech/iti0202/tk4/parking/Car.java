package ee.taltech.iti0202.tk4.parking;

public class Car {

    private int size;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getModel() {
        return name;
    }

    public void getModel(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize() {

    }

    @Override
    public String toString() {
        return  name + "(" + size + ")";
    }
}
