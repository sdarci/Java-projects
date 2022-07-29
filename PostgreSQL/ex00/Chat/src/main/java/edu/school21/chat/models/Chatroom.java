package edu.school21.chat.models;

import java.util.List;

public class Chatroom {

    private Integer chatRoomId;

    private String chatRoomName;

    private String chatRoomOwner;

    private List<Message> massegess;

    public Chatroom(Integer chatRoomId, String chatRoomName, String charRoomOwner, List<Message> masseges) {
        this.chatRoomId = chatRoomId;
        this.chatRoomName = chatRoomName;
        this.chatRoomOwner = charRoomOwner;
        this.massegess = masseges;
    }

    public Integer getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Integer chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }

    public String getCharRoomOwner() {
        return chatRoomOwner;
    }

    public void setCharRoomOwner(String charRoomOwner) {
        this.chatRoomOwner = charRoomOwner;
    }

    public List<Message> getMasseges() {
        return massegess;
    }

    public void setMasseges(List<Message> masseges) {
        this.massegess = masseges;
    }
}
