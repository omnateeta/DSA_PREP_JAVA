class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        res[0] = -((n)*(n-1))/2;
        for(int i=1;i<n;i++){
            res[i] = i;
        }
        return res;
    }
}