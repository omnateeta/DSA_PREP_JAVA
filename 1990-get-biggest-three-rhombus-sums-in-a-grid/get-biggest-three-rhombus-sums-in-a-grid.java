//1878. Get Biggest Three Rhombus Sums in a Grid
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // size 0 rhombus (single cell)
                set.add(grid[r][c]);
                // try larger rhombus sizes
                for (int k = 1; r - k >= 0 && r + k < m && c - k >= 0 && c + k < n; k++) {
                    int sum = 0;
                    int x = r - k;
                    int y = c;
                    // top -> right
                    for (int i = 0; i < k; i++) {
                        sum += grid[x + i][y + i];
                    }
                    // right -> bottom
                    for (int i = 0; i < k; i++) {
                        sum += grid[x + k + i][y + k - i];
                    }
                    // bottom -> left
                    for (int i = 0; i < k; i++) {
                        sum += grid[x + 2 * k - i][y - i];
                    }
                    // left -> top
                    for (int i = 0; i < k; i++) {
                        sum += grid[x + k - i][y - k + i];
                    }
                    set.add(sum);
                }
            }
        }
        int size = Math.min(3, set.size());
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = set.pollLast(); // largest first
        }
        return res;
    }
}