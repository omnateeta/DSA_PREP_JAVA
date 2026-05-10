import java.util.Arrays;

class Solution {

    // -------------------------------------------------------------------------
    // Approach 1: Top-down DP (Memoized Recursion)
    // -------------------------------------------------------------------------

    Integer[] dp;

    public int maximumJumpsTopDown(int[] nums, int target) {

        dp = new Integer[nums.length];

        return helper(0, nums, target);
    }

    private int helper(int ind, int[] nums, int target) {

        if (ind == nums.length - 1)
            return 0;

        if (dp[ind] != null)
            return dp[ind];

        int jumps = -1;

        for (int i = ind + 1; i < nums.length; i++) {

            if (Math.abs(nums[i] - nums[ind]) <= target) {

                int next = helper(i, nums, target);

                if (next != -1)
                    jumps = Math.max(jumps, next + 1);
            }
        }

        return dp[ind] = jumps;
    }

    // -------------------------------------------------------------------------
    // Approach 2: Bottom-up DP (Tabulation)
    // -------------------------------------------------------------------------

    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        dp[n - 1] = 0;

        for (int ind = n - 2; ind >= 0; ind--) {

            for (int i = ind + 1; i < n; i++) {

                if (Math.abs(nums[i] - nums[ind]) <= target
                        && dp[i] != -1) {

                    dp[ind] = Math.max(dp[ind], 1 + dp[i]);
                }
            }
        }

        return dp[0];
    }
}