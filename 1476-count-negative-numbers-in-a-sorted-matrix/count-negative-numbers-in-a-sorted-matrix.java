class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count= 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] < 0){
                    count++;
                }
            }
        }
        return count;
    }
}


// Approach - 2 : // O(m * log(n)) -- Binary Search Optimal

// class Solution {
//     public int countNegatives(int[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         int count = 0;

//         for (int i = 0; i < m; i++) {
//             int l = 0, r = n - 1;
//             while (l <= r) {
//                 int mid = l + (r - l) / 2;
//                 if (grid[i][mid] < 0) {
//                     r = mid - 1;
//                 } else {
//                     l = mid + 1;
//                 }
//             }
//             // l is the first negative index
//             count += (n - l);
//         }
//         return count;
//     }
// }

// Approach - 3: // O(m + n) -- Super Optimal

// class Solution {
//     public int countNegatives(int[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         int row = 0, col = n - 1;
//         int count = 0;

//         while (row < m && col >= 0) {
//             if (grid[row][col] < 0) {
//                 count += (m - row);
//                 col--;
//             } else {
//                 row++;
//             }
//         }
//         return count;
//     }
// }