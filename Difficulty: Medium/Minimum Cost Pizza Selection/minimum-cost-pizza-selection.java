class Solution {
	public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
		// code here
		int INF = Integer.MAX_VALUE;
		
		int[] dp = new int[x + 1];
		
		for (int i = 0; i <= x; i++) {
			dp[i] = INF;
		}
		
		dp[0] = 0;
		
		for (int i = 0; i <= x; i++) {
			
			if (dp[i] == INF) {
				continue;
			}
			
			// Buy Small Pizza
			int newArea = Math.min(x, i + s);
			dp[newArea] = Math.min(dp[newArea],
			dp[i] + cs);
			
			// Buy Medium Pizza
			newArea = Math.min(x, i + m);
			dp[newArea] = Math.min(dp[newArea],
			dp[i] + cm);
			
			// Buy Large Pizza
			newArea = Math.min(x, i + l);
			dp[newArea] = Math.min(dp[newArea],
			dp[i] + cl);
		}
		
		return dp[x];
	}
}
