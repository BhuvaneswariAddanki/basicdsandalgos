package dynamicprogramming;

public class KnapsackProblemZeroByOne {

    // Returns the maximum value that
    // can be put in a knapsack of
    // capacity W
    static int knapSackUsingRecursion(int W, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return knapSackUsingRecursion(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else
            return Math.max(knapSackUsingRecursion(W, wt, val, n - 1),
                    val[n - 1] + knapSackUsingRecursion(W - wt[n - 1], wt, val, n - 1));
    }

    static int knapSackUsingMemorization(int w, int wt[], int val[], int n, int[][] dp) {
        // Base Case
        if (n == 0 || w == 0)
            return 0;


        if (dp[n][w] != -1)
            return dp[n][w];

        // If weight of the nth item is
        // more than Knapsack capacity w,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > w)
            dp[n][w] = knapSackUsingMemorization(w, wt, val, n - 1, dp);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else
            dp[n][w] = Math.max(knapSackUsingMemorization(w, wt, val, n - 1, dp),
                    val[n - 1] + knapSackUsingMemorization(w - wt[n - 1], wt, val, n - 1, dp));
        return dp[n][w];
    }

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSackBottomUpApproach(int weight, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][weight + 1];

        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= weight; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w]
                            = Math.max(val[i - 1]
                                    + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][weight];
    }


    //Space Optimized

    /**
     * For calculating the current row of the dp[] array we require only previous row,
     * but if we start traversing the rows from right to left then it can be done with a single row only
     *
     * @param weight
     * @param wt
     * @param val
     * @param n
     * @return
     */
    static int knapSackUsing1DArrayDP(int weight, int[] wt, int[] val, int n) {
        int[] dp = new int[weight + 1];

        for (int i = 0; i < n; i++) {
            for (int w = weight; w >= 0; w--) {
                if (wt[i] <= w) {
                    dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
                }
            }
        }
        return dp[weight];
    }

    public static void main(String[] args) {
        int profit[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;
        int n = profit.length;
        System.out.print(knapSackUsing1DArrayDP(W, weight, profit, n));
    }


}
