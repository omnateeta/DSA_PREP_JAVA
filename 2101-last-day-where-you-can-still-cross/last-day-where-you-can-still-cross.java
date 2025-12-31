//1970. Last Day Where You Can Still Cross
class Solution {

    private int[] parent, rank;
    private int rows, cols;
    private final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}}; 

    public int latestDayToCross(int row, int col, int[][] cells) {
        rows = row;
        cols = col;
 
        int total = row * col;
        int TOP = total;
        int BOTTOM = total + 1;

        parent = new int[total + 2];
        rank = new int[total + 2];

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        boolean[][] land = new boolean[row][col];

        // Process in reverse order .
        for (int day = cells.length - 1; day >= 0; day--) {
            int r = cells[day][0] - 1;
            int c = cells[day][1] - 1;

            land[r][c] = true;
            int index = r * col + c;

            // Connect neighbors
            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && land[nr][nc]) {
                    union(index, nr * col + nc);
                }
            }

            // Connect to virtual nodes
            if (r == 0) union(index, TOP);
            if (r == row - 1) union(index, BOTTOM);

            // Check connectivity
            if (find(TOP) == find(BOTTOM))
                return day;
        }

        return 0;
    }

    private int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx != ry) {
            if (rank[rx] < rank[ry]) {
                parent[rx] = ry;
            } else if (rank[rx] > rank[ry]) {
                parent[ry] = rx;
            } else {
                parent[ry] = rx;
                rank[rx]++;
            }
        }
    }
}
