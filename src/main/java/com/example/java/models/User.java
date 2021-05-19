package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

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
        return new StringJoiner(", \n", "\n"+User.class.getSimpleName() + "{\n", "}")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("username='" + username + "'")
                .add("webUrl='" + webUrl + "'")
                .toString();
    }
}
