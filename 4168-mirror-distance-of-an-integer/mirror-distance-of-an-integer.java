//3783. Mirror Distance of an Integer.
class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        int rev = 0;
        // Reverse the number .
        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return Math.abs(original - rev);
    }
}
//