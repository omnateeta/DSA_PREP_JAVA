class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 0 ,left = 0,sum = 0;
        for(int right= 0; right < fruits.length;right++){
            sum +=fruits[right][1];
            while(left <= right && getMinSteps(fruits[left][0], fruits[right][0], startPos)>k){
                sum -= fruits[left++][1];
            }
            max=Math.max(max,sum);
        }
        return max;
    }
    public int getMinSteps(int left, int right, int start){
        int leftGo = Math.abs(start-left) + right - left;
        int rightGo = Math.abs(start-right) + right - left;
        return Math.min(leftGo, rightGo);
    }
}