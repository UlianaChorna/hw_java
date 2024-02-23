package threads;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger totalGoodsAmount = new AtomicInteger(100);
        Warehouse warehouse = new Warehouse(totalGoodsAmount, 10);
        Random random = new Random();

        Thread producerThread = new Thread(() -> {
            while (warehouse.getTotalGoodsAmount().get() > 0) {
                if (warehouse.isAdditionalGoodsNeeded()) {
                    warehouse.restock();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread[] customerThreads = new Thread[3];
        for (int i = 0; i < customerThreads.length; i++) {
            final int customerNumber = i + 1;
            customerThreads[i] = new Thread(() -> {
                while (warehouse.getTotalGoodsAmount().get() > 0) {
                    int amount = random.nextInt(10) + 1;
                    System.out.println("Customer :" + customerNumber + " trying to buy :" + amount);
                    warehouse.sellGoods(amount);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Customer " + customerNumber);
        }

        producerThread.start();
        for (Thread customerThread : customerThreads) {
            customerThread.start();
        }
    }
}
