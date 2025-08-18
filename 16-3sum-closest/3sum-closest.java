class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int closest = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++) {
            int start = i+1, end=nums.length-1;
            while(start<end) {
                int sum = nums[i]+nums[start]+nums[end];
                if(sum==target) return sum;
                if(Math.abs(sum-target)<diff) {
                    diff = Math.abs(sum-target);
                    closest = sum;
                }
                if(target>sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return closest;
    }
}