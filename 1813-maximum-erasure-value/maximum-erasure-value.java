class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left=0,right=0;
        Map<Integer,Integer> freq = new HashMap<>();
        int currSum=0, maxSum=0;
        int n=nums.length;
        while(right<n){
            int num = nums[right];
            currSum+=num;
            freq.put(num,freq.getOrDefault(num,0)+1);
            while(freq.get(num)>1){
                int removeNum = nums[left];
                freq.put(removeNum, freq.get(removeNum)-1);
                if(freq.get(removeNum)==0){
                    freq.remove(removeNum);
                   
                }
                 currSum-=removeNum;
                    left++;
            }
             maxSum = Math.max(maxSum, currSum);
                right++;
        }
        return maxSum;
    }
}