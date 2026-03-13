package arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagramsUsingSorting(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sortedString = new String (arr);

            result.putIfAbsent(sortedString, new ArrayList<>());
            result.get(sortedString).add(s);
        }

        return new ArrayList<>(result.values());
    }

    public static List<List<String>> groupAnagramsUsingHashing(String[] strs) {
        HashMap<String, List<String>> result = new HashMap();

        for(String s : strs) {
            int[] count = new int[26];

            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key  = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }

        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        System.out.println("Sorting Approach: " + groupAnagramsUsingSorting(strs));
        System.out.println("Hashing Approach: " + groupAnagramsUsingHashing(strs));
    }
}
