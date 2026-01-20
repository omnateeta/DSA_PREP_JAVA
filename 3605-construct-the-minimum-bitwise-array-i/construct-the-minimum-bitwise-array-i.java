class Solution {

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int target = nums.get(i);

            int answer = -1;      // default if impossible
            int bitMask = 1;      // starts from least significant bit

            // Try removing trailing 1-bits
            while ((target & bitMask) != 0) {
                answer = target - bitMask; // turn off this bit
                bitMask <<= 1;             // move to next bit
            }

            result[i] = answer;
        }

        return result;
    }
}