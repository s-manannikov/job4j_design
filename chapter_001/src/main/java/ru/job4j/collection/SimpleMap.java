package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class SimpleMap<K, V> implements Iterable<K> {
    private Entry[] data = new Entry[16];
    private int size = 0;

    public boolean insert(K key, V value) {
        boolean rsl = false;
        int index = indexOf(key);
        if ((double) size / data.length >= 0.75) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        if (index == -1) {
            data[size] = new Entry(key, value);
            rsl = true;
            size++;
        } else {
            data[index].setValue(value);
        }
        return rsl;
    }

    public V get(K key) {
        return (V) data[indexOf(key)].getValue();
    }

    public boolean delete(K key) {
        boolean rsl = false;
        int index = indexOf(key);
        if (index != -1) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            data[data.length - 1] = null;
            rsl = true;
        }
        return rsl;
    }

    public int indexOf(K key) {
        return IntStream.range(0, size)
                .filter(i -> data[i].getKey().equals(key))
                .findFirst()
                .orElse(-1);
}

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
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