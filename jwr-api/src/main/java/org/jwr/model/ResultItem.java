package org.jwr.model;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

/**
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class ResultItem<T> extends Result {

    /**
     * Object
     */
    private T value;

    public ResultItem() {
    }

    public ResultItem(T value, Result other) {
        super(other);
        this.value = value;
    }

   public <R> ResultItem<R> mapper(Function<T, R> mapper) {
      R other = value == null ? null : mapper.apply(value);
      return new ResultItem(other, this);
   }
}
