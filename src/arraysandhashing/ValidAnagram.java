package arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    public static boolean isAnagramUsingSorting(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    public static boolean isAnagramUsingHashing(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c,0)+1);
        }

        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }

        return sMap.equals(tMap);
    }

    public static boolean isAnagramUsingHashingByArray(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for(char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            frequency[c - 'a']--;
        }

        for(int i : frequency) {
            if(i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println("Sorting Approach: "+ isAnagramUsingSorting(s,t));
        System.out.println("Hashing Approach: "+ isAnagramUsingHashing(s,t));
        System.out.println("Hashing by array Approach: "+ isAnagramUsingHashingByArray(s,t));
    }
}
