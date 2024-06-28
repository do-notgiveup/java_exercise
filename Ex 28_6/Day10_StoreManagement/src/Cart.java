import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;

    public Cart(){
        this.products = new ArrayList<>();
    }
    public ArrayList<Product> getProducts(){
        return products;
    }
    public void addToCart(Product product) {
        products.add(product);
    }

    public double totalPrice() {
        double price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }
        return price;
    }
}
