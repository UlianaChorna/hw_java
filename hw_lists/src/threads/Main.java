package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger totalGoodsAmount = new AtomicInteger(10);
        Warehouse warehouse = new Warehouse(totalGoodsAmount, 5);
        WarehouseManager warehouseManager = new WarehouseManager(warehouse);
        warehouseManager.startSales();
    }
}
