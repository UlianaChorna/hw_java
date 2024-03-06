package product_catalog.manager;

import product_catalog.ProductCatalog;

import java.util.Scanner;

public class DeleteProductByIndexCommand implements Command {

    @Override
    public void execute(ProductCatalog catalog, Scanner scanner) {
        System.out.print("Enter product index to delete: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < catalog.getProductCount()) {
            catalog.deleteProductByIndex(index);
            System.out.println("Product with index " + index + " removed.");
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }
}
