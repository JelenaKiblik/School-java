package ee.taltech.iti0202.stock;
import ee.taltech.iti0202.stock.exceptions.StockException;
import ee.taltech.iti0202.stock.product.Product;
import ee.taltech.iti0202.stock.stock.Stock;

import java.util.Optional;

public class StockDemo {
    private static final int PRICE1 = 3;
    private static final int PRICE2 = 9;
    private static final int PRICE3 = 5;
    private static final int PRICE4 = 6;
    private static final int PRICE5 = 4;
    private static final int MAX_CAPACITY = 4;

    public static void main(String[] args) throws StockException {
        Stock fruitStock = new Stock("fruit-stock-1", MAX_CAPACITY);

        Product cheapApple = new Product("apple", PRICE1);
        Product expensiveApple = new Product("apple", PRICE2);
        Product orange = new Product("orange", PRICE3);
        Product mango = new Product("mango", PRICE4);
        Product pear = new Product("pear", PRICE5);
        System.out.println(pear.getId()); // 5

        fruitStock.addProduct(expensiveApple);
        fruitStock.addProduct(cheapApple);
        System.out.println(fruitStock.getProducts()); // expensiveApple, cheapApple

        Optional<Product> apple = fruitStock.getProduct("apple"); // Optional.of(cheapApple)
        apple.ifPresent(System.out::println); // cheapApple

        fruitStock.addProduct(orange);
        fruitStock.addProduct(mango);
        System.out.println(fruitStock.getProducts().size()); // 4
        System.out.println(fruitStock.getProducts("apple")); // cheapApple, expensiveApple

        try {
            fruitStock.addProduct(pear);
        } catch (StockException e) {
            System.out.println(e.getReason()); // STOCK_IS_FULL
        }

        try {
            fruitStock.addProduct(mango);
        } catch (StockException e) {
            System.out.println(e.getReason()); // STOCK_ALREADY_CONTAINS_PRODUCT
        }

        Optional<Product> removedMango = fruitStock.removeProduct("mango"); // Optional.of(mango)
        removedMango.ifPresent(System.out::println);

        System.out.println(fruitStock.removeProduct("apple")); // Optional[cheapApple]
        System.out.println(fruitStock.removeProduct("apple").get()); // Optional[]
        System.out.println(fruitStock.removeProduct("dumpling")); // Optional.empty

    }
}
