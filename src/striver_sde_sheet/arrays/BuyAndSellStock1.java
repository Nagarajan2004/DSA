package striver_sde_sheet.arrays;

public class BuyAndSellStock1 {

    private int findProfit(int[] prices){
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {17, 20, 11, 9, 12, 6};

        BuyAndSellStock1 buyAndSellStock1 = new BuyAndSellStock1();

        int profit = buyAndSellStock1.findProfit(arr);
        System.out.println(profit);
    }
}
