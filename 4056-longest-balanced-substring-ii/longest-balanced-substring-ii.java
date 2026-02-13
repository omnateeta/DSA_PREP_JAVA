import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxlen = 0;

        // Case 1: Single distinct character (always balanced)
        for (int i = 0; i < n; ) {
            char ch = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == ch) j++;
            int len = j - i;
            maxlen = Math.max(maxlen, len);
            i = j;
        }

        // Case 2: Exactly two distinct characters
        maxlen = Math.max(maxlen, solve2(s, 'a'));
        maxlen = Math.max(maxlen, solve2(s, 'b'));
        maxlen = Math.max(maxlen, solve2(s, 'c'));

        // Case 3: All three characters
        Map<String, Integer> prev = new HashMap<>();
        int ca = 0, cb = 0, cc = 0;
        prev.put("0#0", -1);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') ca++;
            else if (ch == 'b') cb++;
            else cc++;

            String key = (ca - cc) + "#" + (cb - cc);
            if (prev.containsKey(key)) {
                maxlen = Math.max(maxlen, i - prev.get(key));
            } else {
                prev.put(key, i);
            }
        }

        return maxlen;
    }

    int solve2(String s, char skip) {
        int maxlen = 0, n = s.length(), i = 0;

        char first, second;
        if (skip == 'a') { first = 'b'; second = 'c'; }
        else if (skip == 'b') { first = 'a'; second = 'c'; }
        else { first = 'a'; second = 'b'; }

        while (i < n) {
            int c1 = 0, c2 = 0;
            Map<Integer, Integer> prev = new HashMap<>();
            prev.put(0, i - 1);

            while (i < n && s.charAt(i) != skip) {
                if (s.charAt(i) == first) c1++;
                else if (s.charAt(i) == second) c2++;

                int diff = c1 - c2;
                if (prev.containsKey(diff)) {
                    maxlen = Math.max(maxlen, i - prev.get(diff));
                } else {
                    prev.put(diff, i);
                }
                i++;
            }
            i++;
        }
        return maxlen;
    }
}