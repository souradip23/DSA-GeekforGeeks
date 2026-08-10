class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

   int prev1 = 0; // dp[i-1]
        int prev2 = 0; // dp[i-2]

        for (int i = 0; i < h.length; i++) {

            int curr = Math.max(
                h[i] + prev2,
                l[i] + prev1
            );

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}