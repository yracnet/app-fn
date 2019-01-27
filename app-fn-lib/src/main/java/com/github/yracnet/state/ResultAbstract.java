/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.yracnet.state;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public abstract class ResultAbstract implements Result {

    private final String id;
    private String operation;
    private final List<Message> messageList = new ArrayList<>();
    private final List<Action> handlerList = new ArrayList<>();

    public ResultAbstract() {
        id = UUID.randomUUID().toString();
    }

    public ResultAbstract(Result other) {
        id = other.getId();
        operation = other.getOperation();
        other.messageEach(messageList::add);
        other.handlerEach(handlerList::add);
    }

    public ResultAbstract(ResultAbstract other) {
        id = other.id;
        operation = other.operation;
        messageList.addAll(other.messageList);
        handlerList.addAll(other.handlerList);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public void addMessage(Message message) {
        messageList.add(message);
    }

    @Override
    public void messageEach(Consumer<Message> action) {
        messageList.forEach(action);
    }

    @Override
    public void addHandler(Action handler) {
        handlerList.add(handler);
    }

    @Override
    public void handlerEach(Consumer<Action> action) {
        handlerList.forEach(action);
    }

}
