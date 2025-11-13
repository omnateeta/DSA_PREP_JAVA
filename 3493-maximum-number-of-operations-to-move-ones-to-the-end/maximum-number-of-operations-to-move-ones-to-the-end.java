class Solution {
    public int maxOperations(String s) {
        int ones = 0, opr = 0;
        for(int i = 0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '1') {
                ones += 1;
            }else{
                if(i > 0 && s.charAt(i - 1) == '1') {
                    opr += ones;
                } 
            }
        }    
        return opr;    
    }
}