class Solution {
    private static final int MOD = 1_000_000_007;
    private int [][] memo;
    public int numberOfWays(int n, int x) {
        List <Integer> powers = new ArrayList<>();
        for(int i=1; Math.pow(i,x) <= n; i++){
            powers.add((int) Math.pow(i,x));
        }
        memo = new int [n+1] [powers.size()];
        for(int[] row: memo)
            Arrays.fill(row, -1);
        return dfs(powers,n,0);
     }
     private int dfs( List <Integer> powers, int remaining, int index)
     {
        if(remaining == 0)
            return 1;
        if(remaining < 0 || index >= powers.size())
            return 0;
        if(memo[remaining][index] !=-1){
            return memo [remaining][index];
        }
        int take = dfs(powers, remaining - powers.get(index),index+1);

        int skip = dfs (powers, remaining, index+1);

        return memo[remaining][index] =(int) ((take + skip) % MOD);
     }
}