class Solution {
    public int reverseBits(int n) {
        int bits = 32;
        int ans = 0;
        while(bits > 0) {
            if((n & 1)> 0) {
                ans = (ans | 1);
            }
            n=n>>1;
            ans = (bits>1) ? ans << 1 : ans;
            bits--;
        }
        return ans;
    }
}