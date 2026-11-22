class Solution {
	public int longestSubarrayDivK(int[] arr, int k) {
		// code here
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int prefixSum = 0;
		int maxLen = 0;
		
		for (int i = 0; i<arr.length; i++) {
			prefixSum += arr[i];
			int rem = prefixSum % k;
			if (rem < 0) {
				rem += k;
			}
			
			if (map.containsKey(rem)) {
				maxLen = Math.max(maxLen, i - map.get(rem));
			} else {
				map.put(rem, i);
			}
		}
		return maxLen;
	}
}
