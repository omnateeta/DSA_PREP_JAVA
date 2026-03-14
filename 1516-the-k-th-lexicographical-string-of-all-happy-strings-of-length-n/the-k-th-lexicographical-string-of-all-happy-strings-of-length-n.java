//1415. The k-th Lexicographical String of All Happy Strings of Length n
import java.util.*;

class Solution {
    int count = 0;
    String result = "";

    public String getHappyString(int n, int k) {
        backtrack("", n, k);
        return result;
    }

    private void backtrack(String curr, int n, int k) {
        if (curr.length() == n) {
            count++;
            if (count == k) {
                result = curr;
            }
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch) {
                continue;
            }

            backtrack(curr + ch, n, k);

            if (!result.equals("")) return;
        }
    }
}