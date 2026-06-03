class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans1 = solve(landStartTime, landDuration, waterStartTime, waterDuration);
        long ans2 = solve(waterStartTime, waterDuration, landStartTime, landDuration);

        return (int) Math.min(ans1, ans2);
    }

    private long solve(int[] firstStart, int[] firstDur,
                       int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        java.util.Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        int[] starts = new int[m];
        long[] prefixMinDur = new long[m];
        long[] suffixMinStartPlusDur = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        for (int i = 0; i < m; i++) {
            if (i == 0) {
                prefixMinDur[i] = rides[i][1];
            } else {
                prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            long val = (long) rides[i][0] + rides[i][1];
            if (i == m - 1) {
                suffixMinStartPlusDur[i] = val;
            } else {
                suffixMinStartPlusDur[i] =
                        Math.min(val, suffixMinStartPlusDur[i + 1]);
            }
        }

        long best = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {
            long finishFirst = (long) firstStart[i] + firstDur[i];

            int pos = upperBound(starts, (int) finishFirst) - 1;

            long cur = Long.MAX_VALUE;

            if (pos >= 0) {
                cur = Math.min(cur, finishFirst + prefixMinDur[pos]);
            }

            if (pos + 1 < m) {
                cur = Math.min(cur, suffixMinStartPlusDur[pos + 1]);
            }

            best = Math.min(best, cur);
        }

        return best;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}