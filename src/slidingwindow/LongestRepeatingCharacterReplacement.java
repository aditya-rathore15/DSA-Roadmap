package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

/*
LeetCode 424: Longest Repeating Character Replacement
https://leetcode.com/problems/longest-repeating-character-replacement/description/
*/
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int res = 0;

        for(int i=0; i<s.length(); i++){
            HashMap<Character, Integer> count = new HashMap<>();
            int maxf = 0;

            for(int j=i; j<k; j++){
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0)+1);
                maxf = Math.max(maxf, count.get(s.charAt(j)));

                if((j - i + 1) - maxf <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    public static int characterReplacementOptimized(String s, int k) {
        int res = 0;
        HashSet<Character> set = new HashSet<>();

        for(char c : s.toCharArray()) {
            set.add(c);
        }

        for(char c : set) {
            int count = 0;
            int l = 0;

            for(int r = 0; r<s.length(); r++) {
                if(s.charAt(r) == c) {
                    count++;
                }

                while((r - l + 1) - count > k) {
                    if(s.charAt(l) == c) {
                        count--;
                    }

                    l++;
                }

                res = Math.max(res, r - l + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        System.out.println(characterReplacement(s, 2));
    }
}