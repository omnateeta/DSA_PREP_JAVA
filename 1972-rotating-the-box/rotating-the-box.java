class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // Step 1: Apply gravity (move stones to the right)
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // position where next stone should go

            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    empty = j - 1; // reset after obstacle
                } else if (box[i][j] == '#') {
                    // move stone to 'empty' position
                    char temp = box[i][empty];
                    box[i][empty] = '#';
                    box[i][j] = temp;
                    empty--;
                }
            }
        }

        // Step 2: Rotate matrix 90° clockwise
        char[][] result = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = box[i][j];
            }
        }

        return result;
    }
}