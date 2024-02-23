package hw_4;

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
        if (index >= 0 && index < products.size()) {
            products.remove(index);
        }
    }

    public void sortProduct() {
//        products.sort((prod1, prod2) -> prod1.name.compareTo(prod2.name));//тут питання чи це буде працювати
        products.sort(Comparator.comparing(Product::getName)); //так писало  на stackOverFlow
    }

    public List<Product> filterProducts(String keyword) {
        return products.stream()
                .filter(product -> product.getName().contains(keyword))
                .collect(Collectors.toList());
    }

    public void displayProducts() {
        products.forEach(System.out::println);
    }
}


