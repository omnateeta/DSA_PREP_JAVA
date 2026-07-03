//620. Network Recovery Pathways
import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[n];
        int maxCost = 0;

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxCost = Math.max(maxCost, e[2]);
        }

        // Topological order
        int[] topo = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) q.offer(i);

        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] e : graph[u]) {
                if (--indegree[e[0]] == 0)
                    q.offer(e[0]);
            }
        }

        int lo = 0, hi = maxCost;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(mid, graph, topo, online, k)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit,
                          List<int[]>[] graph,
                          int[] topo,
                          boolean[] online,
                          long k) {

        int n = graph.length;
        long INF = Long.MAX_VALUE / 4;

        long[] dp = new long[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int u : topo) {
            if (dp[u] == INF) continue;

            for (int[] e : graph[u]) {
                int v = e[0];
                int cost = e[1];

                if (cost < limit) continue;
                if (v != n - 1 && !online[v]) continue;

                dp[v] = Math.min(dp[v], dp[u] + cost);
            }
        }

        return dp[n - 1] <= k;
    }
}
