class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;

        int[] pos = new int[n + 1];

        // Store position of every value
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int longest = 1;
        int current = 1;

        // Find longest consecutive value sequence
        // whose positions are increasing
        for (int i = 1; i < n; i++) {

            if (pos[i] < pos[i + 1]) {
                current++;
            } else {
                current = 1;
            }

            longest = Math.max(longest, current);
        }

        return n - longest;
    }
}