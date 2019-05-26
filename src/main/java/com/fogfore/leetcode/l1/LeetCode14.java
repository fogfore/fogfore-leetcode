package com.fogfore.leetcode.l1;

/**
 * 最长公共前缀
 *
 * @author fogfore
 */
public class LeetCode14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < common.length(); j++) {
                if (j >= strs[i].length() || common.charAt(j) != strs[i].charAt(j)) {
                    common = common.substring(0, j);
                    break;
                }
            }
        }
        return common;
    }

    public static void main(String[] args) {
        System.out.println(" " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println("fl " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
