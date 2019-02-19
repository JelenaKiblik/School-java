package ee.taltech.iti0202.stock.product;
import ee.taltech.iti0202.stock.exceptions.StockException;

public class Product {

    private final int id;
    private String name;
    private int price;
    private static int nextId = 1;


    public Product(String name, int price) throws StockException {
        this.name = name;
        this.price = price;
        this.id = nextId;
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
