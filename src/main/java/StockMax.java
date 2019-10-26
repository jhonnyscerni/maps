import java.util.Scanner;

public class StockMax {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            int numOfDays = scanner.nextInt();
            int[] prices = new int[numOfDays];
            for (int j = 0; j < numOfDays; j++) {
                prices[j] = scanner.nextInt();
            }
            System.out.println(InvestReturn(prices));
        }
    }

    public static long InvestReturn(int[] prices) {
        long profit = 0;
        long price = 0;
        long loss = 0;
        long maximLocal = prices[prices.length - 1];

        for (int i = prices.length - 1; i >= 0; i--) {

            if (prices[i] >= maximLocal) {
                if (price < prices[i]) {
                    price = prices[i];
                } else {
                    profit += price;
                    if (price != 0) {
                        loss += prices[i];
                    }
                }
            } else {
                profit += price;
                if (price != 0) {
                    loss += prices[i];
                }
            }
        }
        return profit - loss;
    }


}


