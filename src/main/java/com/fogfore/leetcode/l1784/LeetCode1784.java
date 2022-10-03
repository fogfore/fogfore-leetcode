package com.fogfore.leetcode.l1784;

/**
 * 检查二进制字符串字段
 */
public class LeetCode1784 {
    public static void main(String[] args) {

    }

//    public boolean checkOnesSegment(String s) {
//        while (s.length() > 0) {
//            if (s.charAt(0) == '1') {
//                s = s.substring(1);
//            } else {
//                break;
//            }
//        }
//        return !s.contains("1");
//    }

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

}
