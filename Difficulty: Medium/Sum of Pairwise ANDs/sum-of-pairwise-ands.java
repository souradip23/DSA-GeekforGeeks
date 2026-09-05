class Solution {
    public long pairAndSum(int[] arr) {

        long sum = 0;

        for (int bit = 0; bit < 32; bit++) {

            long count = 0;

            // Count numbers having this bit set
            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Number of pairs having this bit set
            long pairs = count * (count - 1) / 2;

            // Contribution of this bit
            sum += pairs * (1L << bit);
        }

        return sum;
    }
}