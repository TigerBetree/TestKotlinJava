package com.test.datastruct;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheTest {

    private LinkedHashMap<Integer, Integer> map = null;
    int capacity = 0;

    public LRUCacheTest(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
