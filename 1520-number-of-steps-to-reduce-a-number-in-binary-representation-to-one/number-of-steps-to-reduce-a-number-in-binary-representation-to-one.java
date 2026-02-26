//1404. Number of Steps to Reduce a Number in Binary Representation to One
class Solution {
    public int numSteps(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        
        while (!sb.toString().equals("1")) {
            int len = sb.length();
            if (sb.charAt(len - 1) == '0') {
                sb.deleteCharAt(len - 1);
            } else {
                int i = len - 1;
                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }
                if (i >= 0) {
                    sb.setCharAt(i, '1');
                } else {
                    sb.insert(0, '1');
                }
            }
            count++;
        }
        
        return count;
    }
}