class Solution {
    public boolean hasAlternatingBits(int n) {
        int hbit = Integer.highestOneBit(n);
        int allones = (hbit<<1)-1;

        if((n ^ (n>>1)) == allones)
            return true;
        return false;
    }
}