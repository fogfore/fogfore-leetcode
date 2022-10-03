package com.fogfore.leetcode.l301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除无效括号
 */
public class LeetCode301 {
    public static void main(String[] args) {
        LeetCode301 leetCode301 = new LeetCode301();
        List<String> ret = leetCode301.removeInvalidParentheses("(a)())()");
        System.out.println(ret);
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> curSet = new HashSet<>();
        curSet.add(s);

        while (curSet.size() > 0) {
            for (String curStr : curSet) {
                if (isInvalid(curStr)) {
                    ans.add(curStr);
                }
            }
            if (ans.size() > 0) {
                return ans;
            }
            Set<String> newSet = new HashSet<>();
            for (String curStr : curSet) {
                for (int i = 0; i < curStr.length(); i++) {
                    if (i > 0 && curStr.charAt(i) == curStr.charAt(i - 1)) {
                    } else if (curStr.charAt(i) == '(' || curStr.charAt(i) == ')') {
                        newSet.add(curStr.substring(0, i) + curStr.substring(i + 1));
                    }
                }
            }
            curSet = newSet;
        }
        return ans;
    }

    public boolean isInvalid(String s) {
        int count = 0;
        for (int i = 0; i < s.length() && count >= 0; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return count == 0;
    }
}
