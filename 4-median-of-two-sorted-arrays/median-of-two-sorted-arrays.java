class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [] arr = new int[n+m];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while(index1<n && index2<m) {
            if(nums1[index1]>nums2[index2]) {
                arr[index] = nums2[index2];
                index2++;
                index++;
            }else{
                arr[index]=nums1[index1];
                index1++;
                index++;
            }
        }
    
    //case1 where index1 is not completed
    while( index1<n) {
        arr[index]=nums1[index1];
        index1++;
        index++;
    }
    //case2 where index2 is not complete
    while(index2<m) {
        arr[index]= nums2[index2];
        index2++;
        index++;
    }
    int k = arr.length;
    //1234===2+3/2=2.5
    if(k%2==0) {
        return (arr[k/2]+arr[k/2-1])/2.0;
    }
    else{
        //1,2,3 =2
        return arr[k/2]/1.0;
    }
}
}