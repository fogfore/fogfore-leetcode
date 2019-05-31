package com.fogfore.leetcode.l1;

/**
 * 报数
 *
 * @author fogfore
 */
public class LeetCode38 {
    public String countAndSay(int n) {
        String result = "1";
        int k;
        for (int i = 1; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < result.length(); j = k) {
                k = j;
                while (k < result.length() && result.charAt(k) == result.charAt(j)) {
                    k++;
                }
                stringBuilder.append(k - j).append(result.charAt(j));
            }
            result = stringBuilder.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode38 leetCode38 = new LeetCode38();
        System.out.println(leetCode38.countAndSay(6));
    }
}
