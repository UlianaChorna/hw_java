package product_catalog.manager;

import product_catalog.ProductCatalog;

import java.util.Scanner;

public class ExitCommand implements Command {
    private final Runnable onExit;

    public ExitCommand(Runnable onExit) {
        this.onExit = onExit;
    }

    @Override
    public void execute(ProductCatalog catalog, Scanner scanner) {
        System.out.println("Exiting the application...");
        onExit.run();
    }
}
