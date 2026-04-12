class Solution {
    Integer[][][] dp;

    public int minimumDistance(String word) {
        int n = word.length();
        dp = new Integer[n][27][27]; // 26 letters + 1 for "not placed"
        return solve(word, 0, 26, 26);
    }

    private int solve(String word, int i, int f1, int f2) {
        if (i == word.length()) return 0;

        if (dp[i][f1][f2] != null) return dp[i][f1][f2];

        int curr = word.charAt(i) - 'A';

        // Move finger1
        int cost1 = getDist(f1, curr) + solve(word, i + 1, curr, f2);

        // Move finger2
        int cost2 = getDist(f2, curr) + solve(word, i + 1, f1, curr);

        return dp[i][f1][f2] = Math.min(cost1, cost2);
    }

    private int getDist(int a, int b) {
        if (a == 26) return 0; // finger not placed yet

        int x1 = a / 6, y1 = a % 6; 
        int x2 = b / 6, y2 = b % 6; 
 
        return Math.abs(x1 - x2) + Math.abs(y1 - y2); 
    }
} 