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
        products.add(product);
        System.out.println("Product added: " + product);
    }

    public void deleteProductByIndex(int index) {
        products.removeIf(product -> product.getIndex() == index);
        reindexProducts();
    }

    public void deleteProductByName(String name) {
        boolean removed = products.removeIf(product -> product.getName().equalsIgnoreCase(name));
        if (removed) {
            reindexProducts();
            System.out.println("Product deleted by name: " + name);
        } else {
            System.out.println("Product not found: " + name);
        }
    }

    private void reindexProducts() {
        for (int i = 0; i < products.size(); i++) {
            products.get(i).setIndex(i);
        }
    }

    public void sortProductsByName() {
        products.sort(Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER));
        System.out.println("Products sorted by name.");
        displayProducts();
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



