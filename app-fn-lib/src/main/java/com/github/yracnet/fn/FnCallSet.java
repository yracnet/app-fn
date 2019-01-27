package com.github.yracnet.fn;

import java.util.List;

@FunctionalInterface
public interface FnCallSet<T, R> {

    public List<R> callSet(T value);
}
