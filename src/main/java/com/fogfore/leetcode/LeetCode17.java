package com.fogfore.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 电话号码的字母组合
 *
 * @author fogfore
 */
public class LeetCode17 {
    public static List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }
        String[] cache = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int size = 1;
        for (int i = 0; i < digits.length(); i++) {
            size *= cache[digits.charAt(i) - '2'].length();
        }
        int delta = size;
        int count = 0;
        int cacheIndex = 0;
        int index;
        StringBuilder[] sbs = new StringBuilder[digits.length() < 1 ? 0 : size];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        for (int i = 0; i < digits.length(); i++) {
            cacheIndex = digits.charAt(i) - '2';
            delta /= cache[cacheIndex].length();
            index = 0;
            count = 0;
            for (StringBuilder sb : sbs) {
                sb.append(cache[cacheIndex].charAt(index));
                count++;
                if (count >= delta) {
                    index = (index + 1) % cache[cacheIndex].length();
                    count = 0;
                }
            }
        }
        return Arrays.stream(sbs).map(StringBuilder::toString).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("23"));
    }
}
