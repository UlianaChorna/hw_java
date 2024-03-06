package product_catalog;

import product_catalog.manager.Command;
import product_catalog.manager.ExitCommand;

import java.util.Scanner;

public class ProductCatalogApp {
    private static boolean running = true;
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        Scanner scanner = new Scanner(System.in);

        // Define the action for exiting
        Runnable exitAction = () -> running = false;
        while (running) {
            System.out.println("\nProduct Catalog Management System");
            MenuOption.printOptions();
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            MenuOption selectedOption = MenuOption.fromInt(choice);
            if (selectedOption == null) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            if (selectedOption == MenuOption.EXIT) {
                new ExitCommand(exitAction).execute(catalog, scanner);
            } else {
                Command command = selectedOption.getCommand();
                command.execute(catalog, scanner);
            }
        }

    }
}
