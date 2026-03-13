package arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;

/*
LeetCode 1: Two Sum
https://leetcode.com/problems/two-sum/description/
*/
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();

        for(int i=0; i<nums.length; i++) {
            int x = target - nums[i];

            if(map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6};
        int target = 10;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
