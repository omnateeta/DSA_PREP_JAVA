class Solution {
    static final int MOD = 1_000_000_007;
    int[][][] memo;
    int limit;
    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        memo = new int[zero + 1][one + 1][2];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (solve(zero, one, 0) + solve(zero, one, 1)) % MOD;
    }
    private int solve(int zerosLeft, int onesLeft, int lastPlaced) {
        if (zerosLeft == 0) {
            return (lastPlaced == 0 || onesLeft > limit) ? 0 : 1;
        }
        if (onesLeft == 0) {
            return (lastPlaced == 1 || zerosLeft > limit) ? 0 : 1;
        }
        if (memo[zerosLeft][onesLeft][lastPlaced] != -1) {
            return memo[zerosLeft][onesLeft][lastPlaced];
        }
        long ways;
        if (lastPlaced == 0) {
            // place zero
            ways = solve(zerosLeft - 1, onesLeft, 0) + solve(zerosLeft - 1, onesLeft, 1);
            if (zerosLeft > limit) {
                ways -= solve(zerosLeft - limit - 1, onesLeft, 1);
            }
        } else {
            // place one
            ways = solve(zerosLeft, onesLeft - 1, 0) + solve(zerosLeft, onesLeft - 1, 1);
            if (onesLeft > limit) {
                ways -= solve(zerosLeft, onesLeft - limit - 1, 0);
            }
        }
        ways = (ways % MOD + MOD) % MOD;
        return memo[zerosLeft][onesLeft][lastPlaced] = (int) ways;
    }
}