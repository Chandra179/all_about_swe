package greedy;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coinDenominations = {25, 10, 5, 1}; // Coin denominations (quarters, dimes, nickels, pennies)
        int amount = 63; // The amount for which we want to make change

        int[] result = makeChange(coinDenominations, amount);

        System.out.println("Minimum number of coins needed: " + result[0]);
        System.out.print("Coins used: [");
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < result[i]; j++) {
                System.out.print(coinDenominations[i - 1]);
                if (i < result.length - 1 || j < result[i] - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println("]");
    }

    public static int[] makeChange(int[] coinDenominations, int amount) {
        Arrays.sort(coinDenominations); // Sort denominations in ascending order
        int[] change = new int[coinDenominations.length + 1];
        int totalCoins = 0;

        for (int i = coinDenominations.length - 1; i >= 0; i--) {
            while (amount >= coinDenominations[i]) {
                amount -= coinDenominations[i];
                change[i + 1]++; // Increment the count of this coin denomination
                totalCoins++;
            }
        }

        // Store the total number of coins used as the first element of the array
        change[0] = totalCoins;

        return change;
    }
}
