package com.github.yracnet.fn;

@FunctionalInterface
public interface FnCallNon<T, R> {

    public R callNon(T value);
}
