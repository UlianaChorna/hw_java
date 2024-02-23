package electronic_shop;

public class TV extends ElectronicEquipment {
    boolean hasSmartTv;

    public TV(String name, double price, boolean hasSmartTv) {
        super(name, price);
        this.hasSmartTv = hasSmartTv;
    }

}
