class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);  
        int n = nums.length;
        int res = 1;

        // case 1: If we choose target not in nums
        int left = 0;
        for(int right=0;right<n;right++){
            while(nums[right] - nums[left] > 2*k) left++;
            int windowSize = right-left+1;
            res = Math.max(res, Math.min(windowSize, numOperations));
        }

        // case 2: If target is in nums
        for(int i=0;i<n;){
            int val = nums[i];
            int j = i;
            while(j<n && nums[j] == val) j++;
            int countEqual = j-i;

            // count numbers wihtin [val-k, val+k]
            int leftBound = lowerBound(nums, val-k);
            int rightBound = upperBound(nums, val+k)-1;
            int inRange = (rightBound >= leftBound) ? (rightBound-leftBound + 1) : 0;

            res = Math.max(res, Math.min(inRange, countEqual+numOperations));

            i=j;
        }

        return res;
    }

    private int lowerBound(int[] arr, int key){
        int l=0,r=arr.length;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid] < key) l= mid+1;
            else r=mid;
        }
        return l;
    }

    private int upperBound(int[] arr, int key){
        int l=0,r=arr.length;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid] <= key) l = mid+1;
            else r=mid;
        }
        return l;
    }
}
