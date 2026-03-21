class Solution:
    def reverseSubmatrix(self, grid, x, y, k):
        start_r = x
        end_r = x + k - 1

        while start_r < end_r:
            for col in range(y, y + k):
                # swap elements
                grid[start_r][col], grid[end_r][col] = (
                    grid[end_r][col],
                    grid[start_r][col],
                )
            start_r += 1
            end_r -= 1

        return grid