package product_catalog;

import product_catalog.manager.*;

import java.util.function.Supplier;

public enum MenuOption {
    ADD_PRODUCT(1, "Add Product", AddProductCommand::new),
    DELETE_PRODUCT_BY_INDEX(2, "Delete Product by Index", DeleteProductByIndexCommand::new),
    DELETE_PRODUCT_BY_NAME(3, "Delete Product by Name", DeleteProductByNameCommand::new),
    DISPLAY_PRODUCTS(4, "Display Products", DisplayAllProductsCommand::new),
    SORT_PRODUCTS_BY_NAME(5, "Sort Products by Name", SortByNameCommand::new),
    FILTER_PRODUCTS_BY_KEYWORD(6, "Filter Products by Keyword", FilterByKeywordCommand::new),
    EXIT(7, "Exit", null);

    private final int option;
    private final String description;
    private final Supplier<Command> commandSupplier;

    MenuOption(int option, String description, Supplier<Command> commandSupplier) {
        this.option = option;
        this.description = description;
        this.commandSupplier = commandSupplier;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public Command getCommand() {
        return commandSupplier.get();
    }

    public static MenuOption fromInt(int option) {
        for (MenuOption menuOption : values()) {
            if (menuOption.getOption() == option) {
                return menuOption;
            }
        }
        return null;
    }

    public static void printOptions() {
        for (MenuOption option : values()) {
            System.out.println(option.getOption() + ". " + option.getDescription());
        }
    }
}
