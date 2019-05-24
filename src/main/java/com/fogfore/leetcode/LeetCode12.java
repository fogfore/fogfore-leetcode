package com.fogfore.leetcode;


/**
 * 整数转罗马数字
 *
 * @author fogfore
 */
public class LeetCode12 {
    public static String intToRoman(int num) {
        if (num < 0 || num > 3999) {
            return null;
        }
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0 && i < ints.length) {
            if (num >= ints[i]) {
                num -= ints[i];
                sb.append(romans[i]);
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(4));
    }
}
