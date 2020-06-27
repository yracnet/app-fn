package org.jwr.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Behavior {

    /**
     * Type Behavior
     */
    private String type;
    /**
     * Action
     */
    private String action;
    /**
     * Parameters
     */
    private final Map<String, String> params = new HashMap<>();

    public void addParam(String name, String value) {
        params.put(name, value);
    }
}
