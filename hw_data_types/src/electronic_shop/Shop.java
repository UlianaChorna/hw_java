package electronic_shop;

public class Shop {
    public static void main(String[] args) {
        ElectronicEquipment Smartphone = new Smartphone("IPhone", 600, "0632534354");
        ElectronicEquipment Laptop = new Laptop("MacBook", 2000, "8GB");
        ElectronicEquipment TV = new TV("LG", 1000, true);

        ShopBasket shopBasket = new ShopBasket();
        shopBasket.addItem(Smartphone, 1);
        shopBasket.addItem(Laptop, 1);
        shopBasket.addItem(TV, 1);


        System.out.println(shopBasket.getTotalAmount());
    }
}