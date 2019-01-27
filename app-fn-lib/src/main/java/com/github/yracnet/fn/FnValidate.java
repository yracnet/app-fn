package com.github.yracnet.fn;

import com.github.yracnet.state.Message;

@FunctionalInterface
public interface FnValidate<T> {

    public Message validate(T value);
}
