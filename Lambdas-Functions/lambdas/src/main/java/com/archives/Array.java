package com.archives;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Array {

    static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();

        for (T element : list) {
            R value = mapper.apply(element);
            result.add(value);
        }

        return result;
    }

    static <T> List<T> filter(List<T> list, Predicate<T> mapper) {
        List<T> result = new ArrayList<>();

        for (T element : list) {
            if (mapper.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    static <E, R> R reduce(
            Iterable<E> iterable,
            R identity,
            BiFunction<R, E, R> accumulator) {

        R result = identity;

        for (E element : iterable) {
            result = accumulator.apply(result, element);
        }

        return result;
    }

}
