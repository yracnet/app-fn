package com.github.yracnet.fn;

import com.github.yracnet.state.Action;

@FunctionalInterface
public interface FnHandler<T> {

    public Action handler(T value);
}
