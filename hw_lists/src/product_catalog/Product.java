package product_catalog;

public class Product {
    public String name;

    private int index;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name:'" + name + '\'' +
                ", index:" + index +
                '}';
    }
}
