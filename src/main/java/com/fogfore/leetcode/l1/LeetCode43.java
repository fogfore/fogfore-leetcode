package com.fogfore.leetcode.l1;

/**
 * 字符串相乘
 *
 * @author fogfore
 */
public class LeetCode43 {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int[] num = new int[l1 + l2];

        for (int i = l1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = l2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                num[l1 - 1 + l2 - 1 - i - j] += n1 * n2;
            }
        }
        int carry = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] + carry >= 10) {
                int sum = num[i] + carry;
                carry = sum / 10;
                num[i] = sum % 10;
            } else {
                num[i] = num[i] + carry;
                carry = 0;
            }
        }

        StringBuilder str = new StringBuilder();
        int l = l1 + l2 - 1;
        while (num[l] == 0)
            l--;

        for (int i = l; i >= 0; i--) {
            str.append(num[i]);
        }

        return str.toString();

    }
//    public String multiply(String num1, String num2) {
//        String[] temp = new String[num2.length()];
//        for (int i = 0; i < num2.length(); i++) {
//            temp[i] = multiply(num1, num2.charAt(num2.length() - i - 1) - '0');
//            for (int j = 0; j < i; j++) {
//                temp[i] += '0';
//            }
//        }
//        String res = add(temp);
//        while (res.length() > 1 && res.startsWith("0")) {
//            res = res.substring(1);
//        }
//        return res;
//    }
//
//    private String multiply(String num1, int num2) {
//        StringBuilder carry = new StringBuilder();
//        StringBuilder product = new StringBuilder();
//        int t;
//        for (int i = 0; i < num1.length(); i++) {
//            t = (num1.charAt(i) - '0') * num2;
//            carry.append(t / 10);
//            product.append(t % 10);
//        }
//        carry.append("0");
//        String res = product.toString();
//        while (res.length() > 1 && res.startsWith("0")) {
//            res = res.substring(1);
//        }
//        return add(res, carry.toString());
//    }
//
//    private String add(String... nums) {
//        StringBuilder carry = new StringBuilder("0");
//        StringBuilder sum = new StringBuilder();
//        int court = 1;
//        boolean flag;
//        int t, c = 0;
//        while (true) {
//            t = 0;
//            flag = true;
//            for (String num : nums) {
//                if (court <= num.length()) {
//                    t += num.charAt(num.length() - court) - '0';
//                    flag = false;
//                }
//            }
//            if (flag) {
//                break;
//            }
//            court++;
//            c += t / 10;
//            carry.insert(0, c % 10);
//            sum.insert(0, t % 10);
//            c = c / 10;
//        }
//        carry.insert(0, c);
//        String res = sum.toString();
//        while (res.length() > 1 && res.startsWith("0")) {
//            res = res.substring(1);
//        }
//        return res.equals(nums[0]) ? res : add(res, carry.toString());
//    }

    public static void main(String[] args) {
        LeetCode43 leetCode43 = new LeetCode43();
        System.out.println(leetCode43.multiply("401716832807512840963", "167141802233061013023557397451289113296441069"));
        System.out.println(leetCode43.multiply("123", "456"));
        System.out.println(leetCode43.multiply("123", "0"));
    }
}
