class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {

        int n = arr.size();

        int sum = 0;

        // First window
        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }

        int maxSum = sum;

        // Slide the window
        for (int i = 1; i < n; i++) {

            // Add new element
            sum += arr.get((i + m - 1) % n);

            // Remove old element
            sum -= arr.get(i - 1);

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
