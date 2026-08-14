class Solution {

    boolean ispal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    int solve(String s, int idx, int n, int[] dp) {

        if (idx == n) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int ans = (int) 1e9;

        for (int i = idx; i < n; i++) {

            if (ispal(s, idx, i)) {

                ans = Math.min(
                    ans,
                    1 + solve(s, i + 1, n, dp)
                );
            }
        }

        return dp[idx] = ans;
    }

    int palPartition(String s) {

        int n = s.length();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(s, 0, n, dp) - 1;
    }
}