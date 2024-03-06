package product_catalog.manager;

import product_catalog.ProductCatalog;

import java.util.Scanner;

public class DisplayAllProductsCommand implements Command {
    @Override
    public void execute(ProductCatalog catalog, Scanner scanner) {
        System.out.println("Displaying all products: ");
        catalog.displayProducts();
    }
}
