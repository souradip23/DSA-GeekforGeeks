class Solution {
	public int pairCount(int x, int y) {
		// code here
		if (y % x != 0) {
			return 0;
		}
		
		int n = y / x;
		int count = 0;
		
		// Find factor pairs of n
		for (int i = 1; i * i <= n; i++) {
			
			if (n % i == 0) {
				
				int j = n / i;
				
				// Only count if i and j are coprime
				if (gcd(i, j) == 1) {
					
					if (i == j) {
						count += 1;
					} else {
						count += 2;
					}
				}
			}
		}
		
		return count;
	}
	
	public int gcd(int a, int b) {
		
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		
		return a;
	}
	
}
