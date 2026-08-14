class Solution {
	public String getLongestPal(String s) {
		// code here
		int n = s.length();
		boolean [][] dp = new boolean[n][n];
		int start = 0;
		int maxlen = 1;
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j<n; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					if (j - i + 1 > maxlen || (j - i + 1 == maxlen && i<start)) {
						maxlen = j - i + 1;
						start = i;
					}
				}
			}
		}
		return s.substring(start, start + maxlen);
	}
}
