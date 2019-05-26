package com.fogfore.leetcode.l1;

import java.util.HashMap;

/**
 * 罗马数字转整数
 *
 * @author fogfore
 */
public class LeetCode13 {
    private static HashMap<Character, Integer> intRomanMap = new HashMap<>();

    static {
        intRomanMap.put('I', 1);
        intRomanMap.put('V', 5);
        intRomanMap.put('X', 10);
        intRomanMap.put('L', 50);
        intRomanMap.put('C', 100);
        intRomanMap.put('D', 500);
        intRomanMap.put('M', 1000);
    }

    public static int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (intRomanMap.get(s.charAt(i)) >= intRomanMap.get(s.charAt(i + 1))) {
                result += intRomanMap.get(s.charAt(i));
            } else {
                result -= intRomanMap.get(s.charAt(i));
            }
        }
        return result += intRomanMap.get(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println("3 " + romanToInt("III"));
        System.out.println("4 " + romanToInt("IV"));
        System.out.println("58 " + romanToInt("LVIII"));
        System.out.println("9 " + romanToInt("IX"));
        System.out.println("1994 " + romanToInt("MCMXCIV"));
    }
}
