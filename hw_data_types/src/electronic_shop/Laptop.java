package electronic_shop;

public class Laptop extends ElectronicEquipment {
    String ramMemory;


    public Laptop(String name, double price, String ramMemory) {
        super(name, price);
        this.ramMemory = ramMemory;
    }

}
