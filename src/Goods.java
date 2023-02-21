import java.util.concurrent.atomic.AtomicInteger;

public class Goods {
    transient private static AtomicInteger idCounter = new AtomicInteger(0);
    private int idBook;
    private String nameProduct;
    private String price;

    public Goods() {
        this.idBook = idCounter.addAndGet(1);
    }

    public Goods(String nameProduct, String price) {
        this.idBook = idCounter.addAndGet(1);
        this.nameProduct = nameProduct;
        this.price = price;

    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getIdBook() + " " + getNameProduct() + " " + getPrice();
    }
}
