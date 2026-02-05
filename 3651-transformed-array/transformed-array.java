class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        for(int i = 0; i < n; i++) {
            int range = i- Math.abs(nums[i]);
            int index = -1;

            if(range >= 0) {
                index = range;
            } else {
                index = (n - Math.abs(nums[i] + i) % n) % n;
            }

            ans[i] = nums[i] >= 0 ? nums[(i + nums[i]) % n] : nums[index];
            }
        return ans;
    }
}