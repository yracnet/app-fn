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
    /**
     * Level Message
     */
    public static enum Level {
        none,
        info,
        warn,
        error,
        fail
    }
    /**
     * Level Message
     */
    private Level level = Level.none;
    /**
     * Code Message
     */
    private String code;
    /**
     * Title Message
     */
    private String title;
    /**
     * Description Message
     */
    private String description;
    /**
     * Causes Message
     */
    private final List<String> causes = new ArrayList<>();
    /**
     * Action Message
     */
    private String action;
    /**
     * Trace Error
     */
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
