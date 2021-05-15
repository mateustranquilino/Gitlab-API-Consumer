package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private long id;
    private String name;
    private String username;

    @JsonProperty("web_url")
    private String webUrl;

    public User(long id, String name, String username, String webUrl) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.webUrl = webUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
