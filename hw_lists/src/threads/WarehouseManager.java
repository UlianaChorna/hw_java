package threads;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class WarehouseManager {
    Random random = new Random();
    private final int CUSTOMER_AMOUNT = 3;
    private final AtomicBoolean isFinalSaleDone = new AtomicBoolean(false);
    private final Warehouse warehouse;
    private final ExecutorService executorService = Executors.newFixedThreadPool(CUSTOMER_AMOUNT);
    private final BlockingQueue<Integer> customerQueue = new LinkedBlockingQueue<>();

    public WarehouseManager(Warehouse warehouse) {
        this.warehouse = warehouse;
        for (int i = 1; i <= CUSTOMER_AMOUNT; i++) {
            customerQueue.add(i);
        }
    }

    public void startSales() {
        while (!isFinalSaleDone.get()) {
            try {
                int customer = customerQueue.take();
                sale(customer);
                customerQueue.add(customer);
                if (warehouse.isAdditionalGoodsNeeded() && !warehouse.restock()) {
                    if (isFinalSaleDone.compareAndSet(false, true)) {
                        finalSale();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            try {
                Thread.sleep(1000); // Затримка для імітації часу між покупками
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        executorService.shutdown();
    }

    private void sale(int customer) {
        executorService.execute(() -> {
            try {
                int amount = random.nextInt(5) + 1;
                System.out.println("Customer :" + customer + " trying to buy :" + amount);
                warehouse.sellGoods(amount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void finalSale() {
        int finalSaleAmount = warehouse.getStockAvailableAmount().get();
        System.out.println("Available amount in stock for final sale " + finalSaleAmount);
        if (finalSaleAmount > 0) {
            finalSale(finalSaleAmount);
        } else {
            System.out.println("No items available for final sale.");
        }

        executorService.shutdown();
        System.out.println("Sale completed.");
    }

    private void finalSale(int finalSaleAmount) {
        System.out.println("Starting final sale...");
        int goodsPerCustomer = finalSaleAmount / CUSTOMER_AMOUNT;
        int remainingGoods = finalSaleAmount % CUSTOMER_AMOUNT;

        for (int customer = 1; customer <= CUSTOMER_AMOUNT; customer++) {
            int amountToSell = goodsPerCustomer + (customer < remainingGoods ? 1 : 0);
            executorService.execute(() -> warehouse.sellGoods(amountToSell));
        }
    }
}
