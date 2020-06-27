package org.jwr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Result implements Serializable {

    private boolean error = false;
    private List<Message> messages = new ArrayList<>();
    private List<Behavior> behaviors = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void addBehavior(Behavior behavior) {
        behaviors.add(behavior);
    }
}
