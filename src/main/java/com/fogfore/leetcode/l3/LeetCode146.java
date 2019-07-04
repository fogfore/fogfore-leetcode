package com.fogfore.leetcode.l3;

import java.util.*;

/**
 * LRU缓存机制
 *
 * @author fogfore
 */
public class LeetCode146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4

        LRUCache cache1 = new LRUCache(2);
        cache.put(2, 6);
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

class LRUCache {
    private int capacity;
    private LinkedList<Page> list;
    private HashMap<Integer, Page> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        Page page = map.get(key);
        if (page == null) {
            return -1;
        }
        list.remove(page);
        list.addFirst(page);
        return page.value;
    }

    public void put(int key, int value) {
        Page page = map.get(key);
        if (page != null) {
            list.remove(page);
            page.value = value;
            list.addFirst(page);
            return;
        }
        if (list.size() >= capacity) {
            Page p = list.removeLast();
            map.remove(p.key);
        }
        page = new Page(key, value);
        list.addFirst(page);
        map.put(key, page);
    }
}

class Page {
    int key;
    int value;

    public Page(int key, int value) {
        this.key = key;
        this.value = value;
    }
}