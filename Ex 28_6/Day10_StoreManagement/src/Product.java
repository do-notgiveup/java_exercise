public class Product {
    private int productId;
    private String productName;
    private double price;
    static final String storeName = "ABC Store";

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", storeName=" + storeName +
                '}';
    }
}
