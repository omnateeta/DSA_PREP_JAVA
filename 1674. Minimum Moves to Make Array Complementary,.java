//1674. Minimum Moves to Make Array Complementary
class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] cost = new int[2 * limit + 2];

        for (int i = 0; i < n /2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            cost[2] +=2; cost[a+1] -=2;
            cost[a+1] +=1;cost[a+b] -=1;
            cost[a+b+1] +=1;cost[b+limit+1] -= 1;
            cost[b+limit+1] +=2;
        }
        int ans = n, curr = 0;
        for (int c = 2; c <= 2 * limit; c++) {
            curr += cost[c];
            ans = Math.min(curr, ans);
        }
        return ans;
    }
}
