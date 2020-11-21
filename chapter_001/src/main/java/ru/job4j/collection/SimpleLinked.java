package ru.job4j.collection;

import java.util.*;

public class SimpleLinked<E> implements Iterable<E> {
    transient int size = 0;
    private int modCount = 0;
    transient Node<E> first;
    transient Node<E> last;

    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new Node(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = first;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current.item;
    }

    public E deleteLast() {
        E rsl = last.item;
        if (first.next == null) {
            first = null;
        } else {
            last.next = null;
        }
        last = last.prev;
        size--;
        modCount++;
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            private Node<E> point = first;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                Node<E> rsl = point;
                point = point.next;
                return (E) rsl;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}