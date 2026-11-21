class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        // code here
       int n = arr.length;
             int minLen = n + 1;
             int currSum = 0;
             int left = 0;

             for (int right = 0; right < n; right++) {
                 currSum += arr[right];

                 while (currSum > x) {
                     minLen = Math.min(minLen, right - left + 1);
                     currSum -= arr[left];
                     left++;
                 }
             }

             return minLen == n + 1 ? 0 : minLen;
    }
}