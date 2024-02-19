package electronic_shop;

public class ElectronicEquipment {
    private String name;
    private double price;

    public ElectronicEquipment(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ElectronicEquipment{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
