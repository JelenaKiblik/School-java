package ee.taltech.iti0202.kt4.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop {

    public List<Product> products = new ArrayList<>();
    public List<Order> orders = new ArrayList<>();
    private static int orderNumber = 0;
    public Product product;
    public List<Optional<Product>> productsInOrder = new ArrayList<Optional<Product>>();

    /**
     * Adds product to shop.
     * If the same instance is already in the shop, returns false.
     * Otherwise adds the product and returns true.
     */
    public boolean addProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Create a new order, take the next int as the order number.
     * Returns the order number.
     */
    public int createNewOrder() {
        orderNumber++;
        return orderNumber;
    }

    /**
     * Creates a new order with specified order number.
     * If the order number is not bigger than the current biggest order number, returns -1.
     * If the order number is correct, then creates the order and returns the number.
     */
    public int createNewOrder(int newNumber) {
        Order order = new Order();
        order.newNumber = createNewOrder();
        orders.add(order);
        return newNumber;
    }

    /**
     * Adds product to order.
     * Product is specified by name. Finds the cheapest available product with the given name.
     * If the order does not exist or the order is cancelled or the order is finished or there are no products,
     * returns false.
     * Otherwise adds the cheapest product to the order and returns true.
     */
    public boolean addProductToOrder(int orderNumber, String itemName) {
//        if (products.contains(itemName) && orders.contains(orderNumber)) {
//            Optional<Product> newProduct = products.stream()
//                    .filter(product -> product.getName() == itemName)
//                    .min(Comparator.comparing(product -> product.getPrice()));
//            productsInOrder.add(newProduct);
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }



    /**
     * Gets the total sum of an order. If order does not exist, returns -1.
     */
    public int getOrderSum(int orderNumber) {
        return -2;
    }

    /**
     * Cancels order.
     * If order does not exist, returns false.
     * If order is already cancelled or is finished, returns false.
     * Otherwise cancels the order and returns true.
     * All the products in the order will be available again.
     */
    public boolean cancelOrder(int orderNumber) {
        return false;
    }

    /**
     * Finishes order.
     * If order does not exist, returns false.
     * If order is already finished or is cancelled, returns false.
     * Otherwise finishes the order and returns true.
     */
    public boolean finishOrder(int orderNumber) {
        return false;
    }

    /**
     * Returns all available products.
     */
    public List<Product> getAvailableProducts() {
        return null;
    }


    /**
     * Returns products of an order.
     * If order does not exists, returns null.
     */
    public List<Product> getOrderProducts(int orderNumber) {
        return null;
    }

    private class Order {
        public int newNumber;
    }
}
