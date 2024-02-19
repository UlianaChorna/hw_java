package electronic_shop;

import java.util.ArrayList;
import java.util.List;

public class ShopBasket {
    List<ElectronicEquipment> items = new ArrayList<>();
    double totalAmount = 0;

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addItem(ElectronicEquipment item, int quantity) {
        this.items.add(item);

        double amount = item.getPrice() * quantity;
        this.totalAmount += amount;

    }

}
