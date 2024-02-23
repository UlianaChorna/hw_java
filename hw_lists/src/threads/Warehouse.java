package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
  private AtomicInteger totalGoodsAmount;//1000
  private final int stockAmount;//100 product
  private  AtomicInteger stockAvailableAmount;// 20 залишок
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
        System.out.println("restock");
        if (this.totalGoodsAmount.get() == 0) {
            System.out.println("Can't do restock");
            return;
        }

        int soldAmount = stockAmount - stockAvailableAmount.get();
        if (totalGoodsAmount.get() >= soldAmount) {
//            System.out.println(soldAmount);
            totalGoodsAmount.addAndGet(-soldAmount);
            stockAvailableAmount.set(stockAmount);
            return;
        }
        System.out.println();

        stockAvailableAmount.addAndGet(totalGoodsAmount.get());
        totalGoodsAmount.set(0);
    }

    public boolean isAdditionalGoodsNeeded() {
        int percentageAvailable = (stockAvailableAmount.get() * 100) / stockAmount;
        return percentageAvailable <= minStockPercentage;
    }

    public void sellGoods(int amount) {
        if (amount <= stockAvailableAmount.get()) {
            System.out.println("Sold - " + amount);
            stockAvailableAmount.addAndGet(-amount);
        } else if (totalGoodsAmount.get() > 0) {
            System.out.println("Not enough goods in stock for sale. We need restock. Available - " + this.totalGoodsAmount.get());
        } else {
            System.out.println("Not enough goods available for sale");
        }
    }
}
