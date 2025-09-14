import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        // Step 1: Prepare lookup maps
        for (String word : wordlist) {
            exact.add(word);
            String lower = word.toLowerCase();

            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(convertVowel(lower), word);
        }

        // Step 2: Process queries
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exact.contains(q)) {
                result[i] = q;  // Exact match
            } else {
                String lower = q.toLowerCase();
                if (caseInsensitive.containsKey(lower)) {
                    result[i] = caseInsensitive.get(lower); // Case-insensitive match
                } else {
                    String cVowel = convertVowel(lower);
                    if (vowelInsensitive.containsKey(cVowel)) {
                        result[i] = vowelInsensitive.get(cVowel); // Vowel-insensitive match
                    } else {
                        result[i] = ""; // No match
                    }
                }
            }
        }
        return result;
    }

    // Helper method to normalize vowels
    private String convertVowel(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                result.append("*");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
