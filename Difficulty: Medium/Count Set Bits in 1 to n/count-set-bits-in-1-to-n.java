class Solution {
    public static int countSetBits(int n) {
        if (n == 0) return 0;

        int x = largestPowerOf2(n);

        int bitsTill2x = x * (1 << (x - 1));
        int msbBits = n - (1 << x) + 1;
        int remaining = n - (1 << x);

        return bitsTill2x + msbBits + countSetBits(remaining);
    }

    static int largestPowerOf2(int n) {
        int x = 0;
        while ((1 << (x + 1)) <= n) {
            x++;
        }
        return x;
    }
}

