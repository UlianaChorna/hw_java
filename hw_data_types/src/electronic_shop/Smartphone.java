package electronic_shop;

public class Smartphone extends ElectronicEquipment {
    String phoneNumber;


    public Smartphone(String name, double price, String phoneNumber) {
        super(name, price);
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return super.toString() +
                " phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
