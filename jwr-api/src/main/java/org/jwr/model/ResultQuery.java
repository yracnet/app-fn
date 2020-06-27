package org.jwr.model;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;

/**
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class ResultQuery<T> extends Result {

    /**
     * Config Result
     */
    private Config config;
    /**
     * List of Object
     */
    private List<T> values;

    public ResultQuery() {
    }

    public ResultQuery(List<T> values, Result other) {
        super(other);
        this.values = values;
    }

    public <R> ResultQuery<R> mapper(Function<T, R> mapper) {
        List<R> list = null;
        if (values != null) {
            list = values.stream().map(mapper).collect(toList());
        }
        return new ResultQuery<>(list, this);
    }
}
