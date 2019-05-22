package com.fogfore.leetcode;

/**
 * Z 字形变换
 *
 * @author fogfore
 */
public class LeetCode6 {
    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 1 || numRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        int index = 0;
        int midIndex = 0;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                index = i;
                while (index < s.length()) {
                    sb.append(s.charAt(index));
                    index += (numRows << 1) - 2;
                }
            } else {
                index = i;
                midIndex = index + ((numRows - i - 1) << 1);
                while (index < s.length() || midIndex < s.length()) {
                    if (index < s.length()) {
                        sb.append(s.charAt(index));
                    }
                    if (midIndex < s.length()) {
                        sb.append(s.charAt(midIndex));
                    }
                    index += (numRows << 1) - 2;
                    midIndex = index + ((numRows - i - 1) << 1);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 4));
        System.out.println(convert("LEETCODEISHIRING", 3));
    }
}
