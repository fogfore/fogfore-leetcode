package com.fogfore.leetcode.l1;

/**
 * 字符串转换整数 (atoi)
 *
 * @author fogfore
 */
public class LeetCode8 {
    public static int myAtoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int result = 0;
        int rest;
        int i = 0;
        boolean isNegative = false;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                isNegative = true;
                i++;
                break;
            } else if (str.charAt(i) == '+') {
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                break;
            }
        }
        for (; i < str.length(); i++) {
            rest = str.charAt(i) - '0';
            if (rest < 0 || rest > 9) {
                break;
            }
            if (result > (Integer.MAX_VALUE - rest) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + rest;
        }
        return isNegative ? result * -1 : result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("+-1"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }
}
