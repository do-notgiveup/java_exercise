import java.util.PrimitiveIterator;

public class ShoppingApp {
    public static void main(String[] args) {

        Product p1 = new Product(1, "sua", 12000);
        Product p2 = new Product(2, "duong", 32000);
        Product p3 = new Product(3, "muoi", 14000);
        Product p4 = new Product(3, "trung", 42000);

        Cart cart = new Cart();
        cart.addToCart(p1);
        cart.addToCart(p2);
        cart.addToCart(p3);
        cart.addToCart(p4);

        for (Product product : cart.getProducts()) {
            System.out.println(product.toString());
        }

        System.out.println("Total price: " + cart.totalPrice());
    }
}