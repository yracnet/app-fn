package org.jwr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Message {
    public static enum Level {
        none,
        info,
        warn,
        error,
        fail
    }
    private Level level = Level.none;
    private String code;
    private String title;
    private String description;
    private final List<String> causes = new ArrayList<>();
    private String action;
    private final List<String> traces = new ArrayList<>();

    public void addCause(boolean when, String value) {
        if (when) {
            causes.add(value);
        }
    }

    public void addCause(String value) {
        causes.add(value);
    }

    public boolean isCauseEmpty() {
        return causes.isEmpty();
    }

    public void addDebug(String value) {
        traces.add(value);
    }

    public boolean isTraceEmpty() {
        return traces.isEmpty();
    }
}
