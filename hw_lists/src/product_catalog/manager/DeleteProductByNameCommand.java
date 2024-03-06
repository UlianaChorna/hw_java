package product_catalog.manager;

import product_catalog.ProductCatalog;

import java.util.Scanner;

public class DeleteProductByNameCommand implements Command {
    @Override
    public void execute(ProductCatalog catalog, Scanner scanner) {
        System.out.print("Enter product name to delete: ");
        String deleteName = scanner.nextLine();
        catalog.deleteProductByName(deleteName);
    }
}
