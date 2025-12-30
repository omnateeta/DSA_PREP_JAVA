class Solution {
    private boolean allElementsDistinct(int startRow, int startCol, int[][] grid) {
        boolean[] numbers = new boolean[10];
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9) {
                    return false;
                }
                if (numbers[num]) {
                    return false;
                }
                numbers[num] = true;
            }
        }
        for (int num = 1; num <= 9; num++) {
            if (!numbers[num]) {
                return false;
            }
        }
        return true;
    }

    private boolean rowSum(int startRow, int startCol, int[][] grid) {
        for (int i = startRow; i < startRow + 3; i++) {
            int rowSum = grid[i][startCol] + grid[i][startCol + 1] + grid[i][startCol + 2];
            if (rowSum != 15) {
                return false;
            }
        }
        return true;
    }

   private boolean colSum(int startRow, int startCol, int[][] grid) {
    for (int j = startCol; j < startCol + 3; j++) {
        int colSum = grid[startRow][j] + grid[startRow + 1][j] + grid[startRow + 2][j];
        if (colSum != 15) {
            return false;
        }
    }
    return true;
}

    private boolean diagonalSum(int startRow, int startCol, int[][] grid) {
 // Calculate the sum of the primary diagonal (top-left to bottom-right)
    int primaryDiagonalSum = grid[startRow][startCol] 
                           + grid[startRow + 1][startCol + 1] 
                           + grid[startRow + 2][startCol + 2];
 // Calculate the sum of the secondary diagonal (top-right to bottom-left)
    int secondaryDiagonalSum = grid[startRow][startCol + 2] 
                             + grid[startRow + 1][startCol + 1] 
                             + grid[startRow + 2][startCol];
    // Check if both diagonals have the same sum (e.g., 15)
    return primaryDiagonalSum == 15 && secondaryDiagonalSum == 15;
}


    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (allElementsDistinct(i, j, grid) && rowSum(i, j, grid) && colSum(i, j, grid)
                        && diagonalSum(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }
}