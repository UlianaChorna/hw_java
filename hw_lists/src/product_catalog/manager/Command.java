package product_catalog.manager;

import product_catalog.ProductCatalog;

import java.util.Scanner;

public interface Command {
    void execute(ProductCatalog catalog, Scanner scanner);
}
