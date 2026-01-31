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

// Approach 2: //O(log n)

// class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         int l = 0, r = letters.length - 1;
//         char ans = letters[0];

//         while (l <= r) {
//             int mid = l + (r - l) / 2;
//             if (letters[mid] > target) {
//                 ans = letters[mid];
//                 r = mid - 1;
//             } else {
//                 l = mid + 1;
//             }
//         }
//         return ans;
//     }
// }