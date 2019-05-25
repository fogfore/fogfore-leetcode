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

//    递归
//    public List<String> letterCombinations(String digits) {
//        if (digits == null || digits.length() == 0) {
//            return new ArrayList();
//        }
//        Map<Character, String> map = new HashMap<Character, String>();
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//        List<String> res = new LinkedList<String>();
//        helper("", digits, 0, res, map);
//        return res;
//
//    }
//
//    private void helper(String s, String digits, int i, List<String> res, Map<Character, String> map) {
//        if (i == digits.length()) {
//            res.add(s);
//            return;
//        }
//        String letters = map.get(digits.charAt(i));
//        for (int j = 0; j < letters.length(); j++){
//            helper(s+letters.charAt(j),digits,i+1,res,map);
//        }
//
//    }
}
