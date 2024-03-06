package product_catalog.manager;

import product_catalog.Product;
import product_catalog.ProductCatalog;

import java.util.Scanner;

public class AddProductCommand implements Command {
    @Override
    public void execute(ProductCatalog catalog, Scanner scanner) {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        if (productName.matches("[a-zA-Z]+")) {
            catalog.addProduct(new Product(productName));
            System.out.println("Product added.");
        } else {
            System.out.println("Product name can only contain letters. Please try again.");
        }
    }
}
