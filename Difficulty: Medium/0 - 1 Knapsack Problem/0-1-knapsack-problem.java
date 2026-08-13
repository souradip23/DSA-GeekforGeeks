class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                // If current item's weight is less than or equal to capacity w
                if (wt[i - 1] <= w) {
                    // Option 1: Exclude item -> dp[i-1][w]
                    // Option 2: Include item -> val[i-1] + dp[i-1][w - wt[i-1]]
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                } else {
                    // Item cannot be included, carry forward previous result
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][W];
    }
}