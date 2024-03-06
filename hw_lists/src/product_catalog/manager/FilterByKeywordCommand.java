package product_catalog.manager;

import product_catalog.Product;
import product_catalog.ProductCatalog;

import java.util.List;
import java.util.Scanner;

public class FilterByKeywordCommand implements Command {
    @Override
    public void execute(ProductCatalog catalog, Scanner scanner) {
        System.out.print("Enter keyword to filter: ");
        String keyword = scanner.nextLine();
        List<Product> filteredProducts = catalog.filterProducts(keyword);
        if (filteredProducts.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("Filtered products: ");
            filteredProducts.forEach(System.out::println);
        }
    }
}
