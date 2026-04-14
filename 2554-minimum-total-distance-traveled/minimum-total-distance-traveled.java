class Solution {

public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
    Collections.sort(robot);                          
    Arrays.sort(factory, (a, b) -> a[0] - b[0]);     

    long[][] dp = new long[robot.size() + 1][factory.length + 1];

    for (int ri = 0; ri <= robot.size(); ri++)
        Arrays.fill(dp[ri], Long.MAX_VALUE);

    for (int fi = 0; fi <= factory.length; fi++)
        dp[robot.size()][fi] = 0;

    for (int ri = robot.size() - 1; ri >= 0; ri--) {
        for (int fi = factory.length - 1; fi >= 0; fi--) {

            long skip = dp[ri][fi + 1];

            long dist = 0;
            long ans = Long.MAX_VALUE;
            for (int k = 0; k < factory[fi][1] && ri + k < robot.size(); k++) {
                dist += Math.abs(robot.get(ri + k) - factory[fi][0]);
                long next = dp[ri + k + 1][fi + 1];
                if (next < Long.MAX_VALUE)
                    ans = Math.min(ans, dist + next);
            }

            dp[ri][fi] = Math.min(skip, ans);
        }
    }

    return dp[0][0];
}

    
}