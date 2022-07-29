package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Integer chatroomId;

    private String name;

    private String owner; //?

    private List<Message> messages;

    public Chatroom (Integer chatroomId, String name, String owner, List<Message> messages) {
        this.chatroomId = chatroomId;
        this.name = name;
        this.owner = owner;
        this.messages = messages;
    }

    public Integer getChatroomId() {
        return this.chatroomId;
    }

    public void setChatroomId(Integer chatroomId) {
        this.chatroomId = chatroomId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return Objects.equals(chatroomId, chatroom.chatroomId) && Objects.equals(name, chatroom.name) && Objects.equals(owner, chatroom.owner) && Objects.equals(messages, chatroom.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatroomId, name, owner, messages);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "chatroomId=" + chatroomId +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", messages=" + messages +
                '}';
    }
}
