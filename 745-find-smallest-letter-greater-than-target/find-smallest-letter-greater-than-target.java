//Approach 1 : //O(n)

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char c = letters[0];
        for(char letter : letters){
            if(target < letter){
                return letter;
            }
        }
        return c;
    }
}