package product_catalog.manager;

import product_catalog.ProductCatalog;

import java.util.Scanner;

public class SortByNameCommand implements Command {
    @Override
    public void execute(ProductCatalog catalog, Scanner scanner) {
        catalog.sortProductsByName();
    }
}
