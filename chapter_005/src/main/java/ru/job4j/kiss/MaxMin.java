package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin<T> {
    List<T> value = new ArrayList<>();

    public T max(Comparator<T> comparator) {
        return findElement((o1, o2) -> comparator.compare(o1, o2) < 0);
    }

    public T min(Comparator<T> comparator) {
        return findElement((o1, o2) -> comparator.compare(o1, o2) > 0);
    }

    public T findElement(BiPredicate<T, T> predicate) {
        T rsl = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            T element = value.get(i);
            if (predicate.test(rsl, element)) {
                rsl = element;
            }
        }
        return rsl;
    }
}