class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;
        int n = encodedText.length();
        int cols = n / rows;
        char[][] grid = new char[rows][cols];
        // Step 1: Fill matrix row-wise
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = encodedText.charAt(idx++);
            }
        }
        // Step 2: Read diagonally
        StringBuilder sb = new StringBuilder();
        for (int startCol = 0; startCol < cols; startCol++) {
            int i = 0, j = startCol;
            while (i < rows && j < cols) {
                sb.append(grid[i][j]);
                i++;
                j++;
            }
        }
        // Step 3: Remove trailing spaces
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
            end--;
        }
        return sb.substring(0, end + 1);
    }
}