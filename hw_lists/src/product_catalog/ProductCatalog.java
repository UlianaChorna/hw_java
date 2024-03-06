package product_catalog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCatalog {
    private List<Product> products;
    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        product.setIndex(products.size());
        products.add((product));
    }

    public void deleteProduct(int index) {
        products.removeIf(product -> product.getIndex() == index);
        reindexProducts();
    }
    private void reindexProducts() {
        for (int i = 0; i < products.size(); i++) {
            products.get(i).setIndex(i);
        }
    }

    public void sortProducts() {
        products.sort(Comparator.comparing(product -> product.getName().toLowerCase()));
    }

    public List<Product> filterProducts(String keyword) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    public int getProductCount() {
        return products.size();
    }

    public void displayProducts() {
        products.forEach(System.out::println);
    }
}



