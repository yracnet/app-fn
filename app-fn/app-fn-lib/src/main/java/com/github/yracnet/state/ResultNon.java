package com.github.yracnet.state;

import com.github.yracnet.fn.FnCallNon;
import com.github.yracnet.fn.FnCallSet;
import com.github.yracnet.fn.FnMapper;
import com.github.yracnet.fn.FnValidate;
import java.util.List;

public class ResultNon<T> extends ResultAbstract implements Result {

    private T value;

    public ResultNon() {
    }

    public ResultNon(T val) {
        value = val;
    }

    public ResultNon(T val, Result result) {
        super(result);
        value = val;
    }

    public ResultNon<T> validate(FnValidate<T> fn) {
        Message message = fn.validate(value);
        if (message != null) {
            addMessage(message);
        }
        return this;
    }

    public <R> ResultNon<R> mapper(FnMapper<T, R> fn) {
        R r = fn.mapper(value);
        return new ResultNon(r, this);
    }

    public <R> ResultSet<R> callSet(FnCallSet<T, R> fn) {
        List<R> list = fn.callSet(value);
        return new ResultSet<>(list, this);
    }

    public <R> ResultNon<R> callNon(FnCallNon<T, R> fn) {
        R result = fn.callNon(value);
        return new ResultNon<>(result, this);
    }

}
