package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable<K> {
    private Entry[] data = new Entry[16];
    private int size = 0;

    public boolean insert(K key, V value) {
        int index = indexOf(key);
        if ((double) size / data.length >= 0.75) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        if (data[index] == null) {
            data[index] = new Entry(key, value);
            size++;
        }
        return true;
    }

    public V get(K key) {
        return (V) data[indexOf(key)].getValue();
    }

    public boolean delete(K key) {
        int index = indexOf(key);
        if (data[index] == null) {
            return false;
        }
        data[index] = null;
        size--;
        return true;
    }

    public int indexOf(K key) {
        int hashCode = key.hashCode();
        int hash = (hashCode == 0) ? hashCode : hashCode ^ (hashCode >>> 16);
        return hash & (data.length - 1);
}

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                for (int i = point; i < data.length; i++) {
                    if (data[i] != null) {
                        point = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K) data[point++].getKey();
            }
        };
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}