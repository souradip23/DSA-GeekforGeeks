class Solution {
	public int maxFrequency(int[] arr, int k) {
		// code here
		Arrays.sort(arr);
		
		int start = 0;
		int maxLen = 0;
		long sum = 0;
		
		for (int end = 0; end < arr.length; end++) {
			
			sum += arr[end];
			
			while ((long) (end - start + 1) * arr[end] - sum > k) {
				sum -= arr[start];
				start++;
			}
			
			int len = end - start + 1;
			
			if (len > maxLen) {
				maxLen = len;
			}
		}
		
		return maxLen;
		
	}
}
