class Solution {
    static boolean isPrime(int n) {
        // code here
        int stm = n/2;
        boolean isPrime = true;

        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= stm; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}