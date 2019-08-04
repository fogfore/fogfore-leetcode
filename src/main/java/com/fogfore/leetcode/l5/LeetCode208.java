package com.fogfore.leetcode.l5;

import org.springframework.data.redis.core.ReactiveRedisCallback;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 实现 Trie (前缀树)
 */
public class LeetCode208 {
    private Node root = new Node('0');

    public LeetCode208() {

    }

    public void insert(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.contain(c)) {
                p = p.get(c);
            } else {
                Node t = new Node(c);
                p.put(c, t);
                p = t;
            }
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.contain(c)) {
                return false;
            }
            p = p.get(c);
        }
        return p.isWord;
    }

    public boolean startsWith(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!p.contain(c)) {
                return false;
            }
            p = p.get(c);
        }
        return true;
    }

    class Node {
        char v;
        boolean isWord;
        HashMap<Character, Node> set = new HashMap<>();

        Node(char v) {
            this.v = v;
        }

        boolean contain(char c) {
            return set.containsKey(c);
        }

        void put(char c, Node node) {
            set.put(c, node);
        }

        Node get(char c) {
            return set.get(c);
        }
    }

    public static void main(String[] args) {
        LeetCode208 l = new LeetCode208();

        l.insert("apple");
        l.search("apple");   // 返回 true
        l.search("app");     // 返回 false
        l.startsWith("app"); // 返回 true
        l.insert("app");
        l.search("app");     // 返回 true
    }
}
