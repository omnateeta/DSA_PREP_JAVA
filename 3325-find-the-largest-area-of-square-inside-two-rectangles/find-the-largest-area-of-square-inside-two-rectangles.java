class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxArea = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int A_blx = bottomLeft[i][0];
                int A_bly = bottomLeft[i][1];
                int A_trx = topRight[i][0];
                int A_try = topRight[i][1];

                int B_blx = bottomLeft[j][0];
                int B_bly = bottomLeft[j][1];
                int B_trx = topRight[j][0];
                int B_try = topRight[j][1];

                // overlap width & height
                int overlapWidth  = Math.min(A_trx, B_trx) - Math.max(A_blx, B_blx);
                int overlapHeight = Math.min(A_try, B_try) - Math.max(A_bly, B_bly);

                if (overlapWidth > 0 && overlapHeight > 0) {
                    int side = Math.min(overlapWidth, overlapHeight);
                    long area = (long) side * side;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}