package com.fogfore.leetcode.l67;

/**
 * 二进制求和
 */
public class LeetCode67 {
    public String addBinary(String a, String b) {
        int alen = a.length() - 1;
        int blen = b.length() - 1;
        int ext = 0;
        StringBuilder sb = new StringBuilder();
        while (alen >= 0 || blen >= 0) {
            int av = alen >= 0 ? a.charAt(alen) - '0' : 0;
            int bv = blen >= 0 ? b.charAt(blen) - '0' : 0;
            int sum = av + bv + ext;
            sb.append(sum % 2);
            ext = sum / 2;
            alen--;
            blen--;
        }
        if (ext == 1) sb.append(ext);
        return sb.reverse().toString();
    }
}
