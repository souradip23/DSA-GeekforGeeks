class Solution {
	public int getMaxWeight(String s) {
		// code here
		int n = s.length();
		int prev2 = 0;
		int prev1 = 0;
		for (int i = 1; i <= n; i++) {
			// Current character ko single rakhne par weight
			int single = prev1 + 1;
			int curr = single;
			if (i >= 2) {
				// Pair ko alternating banane ke liye toggles
				int cost = (s.charAt(i - 2) == s.charAt(i - 1)) ? 1 : 0;
				// Pair weight = 4 - toggles
				int pair = prev2 + 4 - cost;
				curr = Math.max(single, pair);
			}
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}
}
