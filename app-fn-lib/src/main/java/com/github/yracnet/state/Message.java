package com.github.yracnet.state;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Message implements Serializable {

    private final String id;
    private String code;
    private String title;
    private final List<String> causeList = new ArrayList<>();
    private String action;

    public Message() {
        id = UUID.randomUUID().toString();
    }

    public Message(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<String> getCauseList() {
        return causeList;
    }

    public void addCause(String cause) {
        causeList.add(cause);
    }

    public void addCauseWhen(boolean when, String cause) {
        if (when) {
            causeList.add(cause);
        }
    }

    public boolean isCauseEmpty() {
        return !causeList.isEmpty();
    }

    public void required(Filter filter, String cause) {
        if(filter == null || filter.value == null){
            addCause(cause);
        }
    }

    public void required(Object value, String cause) {
        if(value == null){
            addCause(cause);
        }
    }

}
