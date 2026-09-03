class Solution {
    public int maxDiffSum(int[] arr) {

        int n = arr.length;

        if (n <= 1) {
            return 0;
        }

        long keep = 0;
        long replace = 0;

        for (int i = 1; i < n; i++) {

            long oldKeep = keep;
            long oldReplace = replace;

            keep = Math.max(
                oldKeep + Math.abs(arr[i] - arr[i - 1]),
                oldReplace + Math.abs(arr[i] - 1)
            );

            replace = Math.max(
                oldKeep + Math.abs(arr[i - 1] - 1),
                oldReplace
            );
        }

        return (int)Math.max(keep, replace);
    }
}