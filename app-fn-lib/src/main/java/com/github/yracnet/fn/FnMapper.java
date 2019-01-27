package com.github.yracnet.fn;

@FunctionalInterface
public interface FnMapper<T, R> {

    public R mapper(T t);
}
