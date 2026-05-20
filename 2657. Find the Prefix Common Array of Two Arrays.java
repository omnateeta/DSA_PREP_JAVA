//2657. Find the Prefix Common Array of Two Arrays
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        
        int[] freq = new int[n + 1];
        int[] ans = new int[n];
        
        int common = 0;
        
        for (int i = 0; i < n; i++) {
            
            // Process A[i]
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                common++;
            }
            
            // Process B[i]
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                common++;
            }
            
            ans[i] = common;
        }
        
        return ans;
    }
}
