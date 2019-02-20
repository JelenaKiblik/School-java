package ee.taltech.iti0202.stock.product;
import ee.taltech.iti0202.stock.exceptions.StockException;

public class Product {
    private String name;
    private int price;
    private static int id = 0;

    public Product(String name, int price) throws StockException {
        this.name = name;
        this.price = price;
        getNextId();

    }

    public static int getNextId() {
        id++;
        return id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        if (price >= 0) return price;
        return 0;
    }
}
