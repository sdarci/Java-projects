package edu.school21.chat.models;

import java.time.LocalDateTime;

public class Message {

    private Integer Identifier;

    private User author;

    private Chatroom room;

    private String text;

    private LocalDateTime messageDateTime;

    public Message(Integer identifier, User author, Chatroom room, String text, LocalDateTime messageDateTime) {
        Identifier = identifier;
        this.author = author;
        this.room = room;
        this.text = text;
        this.messageDateTime = messageDateTime;
    }

    public Integer getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(Integer identifier) {
        Identifier = identifier;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(LocalDateTime messageDateTime) {
        this.messageDateTime = messageDateTime;
    }
}
