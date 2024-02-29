package product_catalog;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Sort Products");
            System.out.println("4. Filter Products");
            System.out.println("5. Display Products");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");


            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (option) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    if (productName.matches("[a-zA-Z]+")) {
                        catalog.addProduct(new Product(productName));
                        System.out.println("Product added.");
                    } else {
                        System.out.println("Product name can only contain letters. Please try again.");
                    }
                    break;
                case 2:
                    System.out.print("Enter product index to remove: ");
                    String indexToRemoveStr = scanner.nextLine();
                    try {
                        int productIndexToRemove = Integer.parseInt(indexToRemoveStr);
                        if (productIndexToRemove >= 0 && productIndexToRemove < catalog.getProductCount()) {
                            catalog.deleteProduct(productIndexToRemove);
                            System.out.println("Product removed.");
                        } else {
                            System.out.println("Invalid index. Please enter a valid index.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    break;
                case 3:
                    catalog.sortProducts();
                    System.out.println("Products sorted.");
                    break;
                case 4:
                    System.out.print("Enter keyword to filter: ");
                    String keyword = scanner.nextLine();
                    List<Product> filteredProducts = catalog.filterProducts(keyword);
                    if (filteredProducts.isEmpty()) {
                        System.out.println("No products found.");
                    } else {
                        filteredProducts.forEach(System.out::println);
                    }
                    break;
                case 5:
                    if (catalog.getProductCount() == 0) {
                        System.out.println("The product catalog is empty.");
                    } else {
                        catalog.displayProducts();
                    }
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
