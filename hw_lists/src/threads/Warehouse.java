package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
  private AtomicInteger totalGoodsAmount;
  private final int stockAmount;
  private  AtomicInteger stockAvailableAmount;
  private final int minStockPercentage = 20;


    public Warehouse(AtomicInteger totalGoodsAmount, int stockAmount) {
        this.stockAmount = stockAmount;
        this.totalGoodsAmount = totalGoodsAmount;
        this.stockAvailableAmount = new AtomicInteger(stockAmount);
    }

    public AtomicInteger getTotalGoodsAmount() {
        return totalGoodsAmount;
    }

    public void restock() {
        if (this.totalGoodsAmount.get() == 0) {
            System.out.println("Can't do restock");
            return;
        }

        int soldAmount = stockAmount - stockAvailableAmount.get();
        if (totalGoodsAmount.get() >= soldAmount) {
            System.out.println("Adding to stock " + soldAmount);
            totalGoodsAmount.addAndGet(-soldAmount);
            stockAvailableAmount.set(stockAmount);
            return;
        }

        System.out.println("Adding to stock rest " + totalGoodsAmount.get());
        stockAvailableAmount.addAndGet(totalGoodsAmount.get());
        totalGoodsAmount.set(0);
    }

    public boolean isAdditionalGoodsNeeded() {
        int percentageAvailable = (stockAvailableAmount.get() * 100) / stockAmount;
        return percentageAvailable <= minStockPercentage;
    }

    public synchronized void sellGoods(int amount) {
        if (amount <= stockAvailableAmount.get()) {
            System.out.println("Sold - " + amount);
            stockAvailableAmount.addAndGet(-amount);
        } else if (totalGoodsAmount.get() > 0) {
            System.out.println("Not enough goods in stock for sale. We need restock. Available in stock - " + this.stockAvailableAmount.get());
        } else {
            System.out.println("Not enough goods available for sale");
        }
    }
}
