package org.jwr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Basic Result Response for Request
 *
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Result implements Serializable {

    /**
     * Flag attribute for error result
     */
    private boolean error = false;
    /**
     * List of Message
     */
    private List<Message> messages = new ArrayList<>();
    /**
     * List of Behavior
     */
    private List<Behavior> behaviors = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void addBehavior(Behavior behavior) {
        behaviors.add(behavior);
    }
}
