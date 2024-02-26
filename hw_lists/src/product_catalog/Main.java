package hw_4;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Sort Products");
            System.out.println("4. Filter Products");
            System.out.println("5. Display Products");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    catalog.addProduct(new Product(productName));
                    break;
                case 2:
                    System.out.print("Enter index to remove: ");
                    int indexToRemove = scanner.nextInt();
                    catalog.deleteProduct(indexToRemove);
                    break;
                case 3:
                    catalog.sortProduct();
                    break;
                case 4:
                    System.out.print("Enter keyword to filter: ");
                    String keyword = scanner.nextLine();
                    List<Product> filteredProducts = catalog.filterProducts(keyword);
                    filteredProducts.forEach(System.out::println);
                    break;
                case 5:
                    catalog.displayProducts();
                break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
