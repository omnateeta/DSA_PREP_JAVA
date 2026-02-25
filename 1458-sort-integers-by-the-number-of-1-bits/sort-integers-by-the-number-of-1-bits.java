class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        for(int a : arr){
            int count = Integer.bitCount(a);
            list.add(new int[]{a, count});
        }
        Collections.sort(list, (a,b) -> a[1] != b[1] ? a[1] - b[1] : a[0] -b[0]);
        int[] res = new int[n];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i)[0];
        }
        return res;
    }
}
