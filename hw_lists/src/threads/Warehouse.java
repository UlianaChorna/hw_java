package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
  private final AtomicInteger totalGoodsAmount;
  private final int stockAmount;
  private AtomicInteger stockAvailableAmount;
  private final int minStockPercentage = 20;


    public Warehouse(AtomicInteger totalGoodsAmount, int stockAmount) {
        this.stockAmount = stockAmount;
        this.totalGoodsAmount = totalGoodsAmount;
        this.stockAvailableAmount = new AtomicInteger(stockAmount);
    }

    public synchronized boolean restock() {
        System.out.println("********* Restock *********");
        if (this.totalGoodsAmount.get() == 0) {
            System.out.println("Can't do restock because no more goods left. Preparing for final sale.");
            return false;
        }

        int neededAmount = stockAmount - stockAvailableAmount.get();
        int restockAmount = Math.min(neededAmount, totalGoodsAmount.get());
        System.out.println("Adding to stock: " + restockAmount);
        stockAvailableAmount.addAndGet(restockAmount);
        totalGoodsAmount.addAndGet(-restockAmount);
        return true;
    }

    public synchronized boolean isAdditionalGoodsNeeded() {
        int percentageAvailable = (stockAvailableAmount.get() * 100) / stockAmount;
        return percentageAvailable <= minStockPercentage;
    }

    public synchronized void sellGoods(int amount) {
        if (amount <= stockAvailableAmount.get()) {
            System.out.println("Sold - " + amount);
            stockAvailableAmount.addAndGet(-amount);
        } else {
            System.out.println("Not enough goods in stock for sale. We need restock. Available in stock - "
                    + this.stockAvailableAmount.get());
        }
    }

    public AtomicInteger getStockAvailableAmount() {
        return stockAvailableAmount;
    }
}
