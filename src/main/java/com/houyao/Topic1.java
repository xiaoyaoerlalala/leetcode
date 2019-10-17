package com.houyao;

import java.util.HashMap;
import java.util.Map;

public class Topic1 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        /**
         * 通过以空间换取速度的方式，我们可以将查找时间从 O(n)O(n)O(n) 降低到 O(1)O(1)O(1)。哈希表正是为此目的而构建的
         * 它支持以 近似 恒定的时间进行快速查找。我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)O(n)O(n)。
         * 但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)O(1)O(1)。
         */
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");*/
        int[] array = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i<nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) && (map.get(num) != i)) {
                array[0] = i;
                array[1] = map.get(nums[i]);
            }
        }
        return array;
    }

    /**
     * 暴力法
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
