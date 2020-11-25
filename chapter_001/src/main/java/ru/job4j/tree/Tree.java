package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> rsl = findBy(parent);
        if (findBy(child).isPresent() || rsl.isEmpty()) {
            return false;
        }
        return rsl.get().children.add(new Node<>(child));
    }

    public boolean isBinary() {
        return findByCondition(i -> i.children.size() > 2).isEmpty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByCondition(i -> i.value.equals(value));
    }

    private Optional<Node<E>> findByCondition(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}