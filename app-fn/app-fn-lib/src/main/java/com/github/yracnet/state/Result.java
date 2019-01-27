package com.github.yracnet.state;

import java.util.function.Consumer;

public interface Result {

    public String getId();

    public String getOperation();

    public void addHandler(Action handler);

    public void handlerEach(Consumer<Action> action);

    public void addMessage(Message message);

    public void messageEach(Consumer<Message> action);

    public static <T> ResultNon<T> createResultNon() {
        return new ResultNon<>();
    }

    public static <T> ResultSet<T> createResultSet() {
        return new ResultSet<>();
    }

}
