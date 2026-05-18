//1345. Jump Game IV
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        // Base cases
        if (n == 1) return 0;
        if (n == 2) return 1;

        // Map each value to all indices that share it (for same-value jumps)
        // Time: O(n), Space: O(n)
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hmap.containsKey(arr[i]))
                hmap.put(arr[i], new ArrayList<>());
            hmap.get(arr[i]).add(i);
        }

        // BFS to find shortest path (min jumps) from index 0 to index n-1
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (curr == n - 1) return dist[n - 1];

            // Jump left
            if (curr - 1 >= 0 && dist[curr - 1] < 0) {
                dist[curr - 1] = dist[curr] + 1;
                q.add(curr - 1);
            }

            // Jump right
            if (curr + 1 < n && dist[curr + 1] < 0) {
                dist[curr + 1] = dist[curr] + 1;
                q.add(curr + 1);
            }

            // Jump to all same-value indices
            List<Integer> temp = hmap.get(arr[curr]);
            for (int i = 0; i < temp.size(); i++) {
                if (dist[temp.get(i)] < 0) {
                    dist[temp.get(i)] = dist[curr] + 1;
                    q.add(temp.get(i));
                }
            }
            // Clear to avoid revisiting same-value indices (prevents O(n^2) on duplicates e.g. [2,2,2,2,2])
            temp.clear();
        }

        return dist[n - 1];
    }
}

//Given an array of integers arr, you are initially positioned at the first index of the array.

// In one step you can jump from index i to index:

// i + 1 where: i + 1 < arr.length.
// i - 1 where: i - 1 >= 0.
// j where: arr[i] == arr[j] and i != j.
// Return the minimum number of steps to reach the last index of the array.

// Notice that you can not jump outside of the array at any time.

 

// Example 1:

// Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
// Output: 3
// Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
// Example 2:

// Input: arr = [7]
// Output: 0
// Explanation: Start index is the last index. You do not need to jump.
// Example 3:

// Input: arr = [7,6,9,6,9,6,9,7]
// Output: 1
// Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 

// Constraints:

// 1 <= arr.length <= 5 * 104
// -108 <= arr[i] <= 108
