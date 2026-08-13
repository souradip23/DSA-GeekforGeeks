class Solution {
	int maxSubarraySum(int[] arr) {
		// Code here
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i<arr.length; i++) {
			
			sum += arr[i];
			maxSum = Math.max(sum, maxSum);
			
			if (sum<0) {
				sum = 0;
			}
		}
		return maxSum;
	}
}
