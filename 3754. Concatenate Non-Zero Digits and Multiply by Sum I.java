class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) {
            return 0;
        }
        
        long x = 0;
        long sum = 0;
        long multiplier = 1;
        
        // Process digits from right to left
        while (n > 0) {
            int digit = n % 10;
            
            // Only process non-zero digits
            if (digit != 0) {
                x = x + (digit * multiplier);
                multiplier *= 10; // Shift left for the next non-zero digit
                sum += digit;
            }
            
            n /= 10; // Move to the next digit
        }
        
        return x * sum;
    }
}
