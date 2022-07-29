package edu.school21.chat.models;

import java.util.List;

public class User {
    private Integer userId;

    private String login;

    private String pass;

    private List<Chatroom> createdRooms;

    private List<Chatroom> socializedRooms;

    public User(Integer userId, String login, List<Chatroom> createdRooms, List<Chatroom> socializedRooms, String pass) {
        this.userId = userId;
        this.login = login;
        this.createdRooms = createdRooms;
        this.socializedRooms = socializedRooms;
        this.pass = pass;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<Chatroom> getSocializedRooms() {
        return socializedRooms;
    }

    public void setSocializedRooms(List<Chatroom> socializedRooms) {
        this.socializedRooms = socializedRooms;
    }
}
