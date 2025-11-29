class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int rem = sum%k;

        return rem;
    }
}
// class Solution {
//     public int minOperations(int[] nums, int k) {
//         // Compute sum using streams
//         int sum = Arrays.stream(nums).sum();

//         // Remainder when divided by k
//         int rem = sum % k;

//         return rem;
//     }
// }