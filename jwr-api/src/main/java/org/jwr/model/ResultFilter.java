package org.jwr.model;

import java.util.List;

/**
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class ResultFilter<T> extends Result {

    /**
     * Config Result
     */
    private Config config;
    /**
     * List of Object
     */
    private List<T> values;
}
