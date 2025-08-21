class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [][] height = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n;j++) {
                if(mat[i][j] == 0)
                    height[i][j]=0;
                else
                    height[i][j]=(i==0 ? 1 : height[i - 1][j] + 1);
            }
        }
        int total = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(height[i][j] > 0) {
                    int minHeight = height[i][j];
                for(int k=j; k>=0; k--){
                    if(height[i][k] == 0) break;
                    minHeight = Math.min(minHeight, height[i][k]);
                    total += minHeight;
                    }
                }
            }
        }
        return total;
    }
}