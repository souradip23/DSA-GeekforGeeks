class Solution {
	public String findRollOut(String s, int[] roll) {
		// code here
		int n = s.length();
		int[] cnt = new int[n];
		for (int r : roll) {
			if (r > 0)
				cnt[r - 1]++;
		}
		char[] c = s.toCharArray();
		int run = 0;
		for (int i = n - 1; i >= 0; i--) {
			run += cnt[i];
			c[i] = (char) ('a' + (c[i] - 'a' + run) % 26);
		}
		return new String(c);
	}
}
