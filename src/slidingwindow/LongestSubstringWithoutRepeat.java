package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
LeetCode 3: Longest Substring Without Repeating Characters
Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeat {

    /*
    Brute Force:
    Time Complexity - O(n^2)
     */
    public static int lengthOfLongestSubstringBruteForce(String s) {
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++) {
            int currentLength = 0;
            HashSet<Character> set = new HashSet<>();

            for(int j = i; j < s.length(); j++) {

                if(set.contains(s.charAt(j))) {
                    break;
                }

                set.add(s.charAt(j));
                currentLength++;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    /*
    Optimized Approach:
    Sliding Window

    TimeComplexity - O(n) SpaceComplexity - O(m)
     */
    public static int lengthOfLongestSubstringOptimized(String s) {
        int l = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        for(int r = 0; r<s.length(); r++) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));
            maxLength = Math.max(maxLength, r-l+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println("Brute Force: "+ lengthOfLongestSubstringBruteForce(s));
        System.out.println("Optimized: "+ lengthOfLongestSubstringOptimized(s));
    }
}
