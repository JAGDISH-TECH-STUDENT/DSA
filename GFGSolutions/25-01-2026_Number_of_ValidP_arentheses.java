class Solution {
    int findWays(int n) {
        if (n % 2 != 0) return 0;

        int k = n / 2;
        return catalan(k);
    }
    int catalan(int n) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res = res * (2 * n - i) / (i + 1);
        }
        return (int)(res / (n + 1));
    }
}

