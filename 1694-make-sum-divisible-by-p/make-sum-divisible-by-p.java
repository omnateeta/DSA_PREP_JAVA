class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for(int num:nums) totalSum += num;

        int rem = (int)(totalSum % p);
        if(rem == 0) return 0;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0;
        int ans = nums.length;

        for(int i=0;i<nums.length;i++){
            prefix = (prefix + nums[i]) % p;
            int target = (prefix - rem + p)%p;

            if(map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }

            map.put(prefix, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}