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

    private String type;
    private String action;
    private final Map<String, String> params = new HashMap<>();

    public void addParam(String name, String value) {
        params.put(name, value);
    }
}
