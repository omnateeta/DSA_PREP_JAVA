class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        final int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        int[] pre = new int[n + 1];
        dp[0] = 1;
        pre[0] = 1;
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();
        int left = 0;
        for (int r = 0; r < n; r++) {
            // Maintain max deque
            while (!maxD.isEmpty() && maxD.peekLast() < nums[r]){
                maxD.pollLast();
            }
            maxD.addLast(nums[r]);
            // Maintain min deque
            while (!minD.isEmpty() && minD.peekLast() > nums[r]){
                minD.pollLast();
            }
            minD.addLast(nums[r]);
            // Shrink left until window max-min <= k
            while (!maxD.isEmpty() && !minD.isEmpty() &&
                   maxD.peekFirst() - minD.peekFirst() > k) {

                if (maxD.peekFirst() == nums[left]) maxD.pollFirst();
                if (minD.peekFirst() == nums[left]) minD.pollFirst();
                left++;
            }
            // dp[r+1] = sum(dp[left .. r])
            long total = pre[r];
            long remove = (left == 0 ? 0 : pre[left - 1]);
            dp[r + 1] = (int) ((total - remove + MOD) % MOD);
            pre[r + 1] = (pre[r] + dp[r + 1]) % MOD;
        }
        return dp[n];
    }
}
