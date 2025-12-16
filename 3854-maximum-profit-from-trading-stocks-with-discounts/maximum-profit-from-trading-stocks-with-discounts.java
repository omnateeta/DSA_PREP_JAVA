class Result{
    int[] noParentBuy; //dp when parent did not buy
    int[] parentBuy; // dp when parent did  buy
    int maxCost; //max possible cost in this subtree

    Result(int[] a, int[] b, int c){
        noParentBuy = a;
        parentBuy = b;
        maxCost = c;
    }
}

class Solution {
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        List<Integer>[] tree = new ArrayList[n];
        for(int i=0;i<n;i++){
            tree[i] =new ArrayList<>();
        }
        for(int[] e : hierarchy){
            tree[e[0] - 1].add(e[1] - 1);
        }
        //CEO has no parent --> parent did not buy
        return dfs(0,present, future, tree, budget).noParentBuy[budget];
    }

    private Result dfs(int u, int[] present, int[] future,  List<Integer>[] tree, int budget){
        int fullCost = present[u];
        int discCost = present[u] / 2;
        int profitFull = future[u] - fullCost;
        int profitDisc = future[u] - discCost;

        //dp Arrays
        int[] noParentBuy = new int[budget + 1];
        int[] parentBuy = new int[budget + 1];

        //merged children profit

        int[] childNoDisc = new int[budget + 1];
        int[] childDisc = new int[budget + 1];

        int maxCost = 0;

        //Merge Children (tree knapsack)
        for(int v : tree[u]){
            Result child = dfs(v,present, future, tree, budget);
            maxCost += child.maxCost;

            for(int cur = budget;cur >= 0 ;cur--){
                for(int take = 0; take <= Math.min(child.maxCost, cur); take++){
                    childNoDisc[cur] = Math.max(childNoDisc[cur], childNoDisc[cur - take] +  child.noParentBuy[take]);
                    childDisc[cur] = Math.max(childDisc[cur], childDisc[cur - take] +  child.parentBuy[take]);
                }
            }
        }
        
        //Decide buy or skip node u
        for(int b = 0;b<= budget;b++){
            //skip u
            noParentBuy[b] = childNoDisc[b];
            parentBuy[b] = childNoDisc[b];

            //buy u (no discount)

            if(b >= fullCost){
                 noParentBuy[b] = Math.max( noParentBuy[b], childDisc[b- fullCost] + profitFull);
            }

            //buy u (with discount)

            if(b >= discCost){
                 parentBuy[b] = Math.max( parentBuy[b], childDisc[b- discCost] + profitDisc);
            }
        }

        return new Result(noParentBuy, parentBuy, maxCost + fullCost);

    }
}