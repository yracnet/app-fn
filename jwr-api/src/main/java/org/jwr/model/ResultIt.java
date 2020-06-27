package org.jwr.model;

/**
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class ResultIt<T> extends Result {

    /**
     * Object
     */
    private T value;
}
