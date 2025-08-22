class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int minRow = n, maxRow =-1;
        int minCol = m, maxCol =-1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    minRow = Math.min(minRow,i);
                    maxRow = Math.max(maxRow,i);
                    minCol = Math.min(minCol,j);
                    maxCol = Math.max(maxCol,j);
                }
            }
        }
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        return height * width;
    }
}