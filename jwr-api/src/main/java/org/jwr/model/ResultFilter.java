package org.jwr.model;

import java.util.List;

/**
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class ResultFilter<T> extends Result {

    private Config config;
    private List<T> values;
}
