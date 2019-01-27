package com.github.yracnet.state;

import com.github.yracnet.fn.FnMapper;
import java.util.ArrayList;
import java.util.List;

public class ResultSet<T> extends ResultAbstract implements Result {

    private List<T> value;

    public ResultSet() {
    }

    public ResultSet(List<T> list) {
        value = list;
    }

    public ResultSet(List<T> list, Result result) {
        super(result);
        value = list;
    }

    public <R> ResultSet<R> mapper(FnMapper<T, R> fn) {
        List<R> list = new ArrayList<>();
        value.forEach(t -> list.add(fn.mapper(t)));
        return new ResultSet(list, this);
    }
}
