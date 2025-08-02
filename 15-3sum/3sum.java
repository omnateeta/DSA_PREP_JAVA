class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                List<Integer> List = new ArrayList<>();
                if(sum ==0){
                    List.add(nums[i]);
                    List.add(nums[j]);
                    List.add(nums[k]);
                    j++;
                    k--;
                    result.add(List);
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}