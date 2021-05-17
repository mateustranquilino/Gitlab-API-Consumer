package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Commit {
    private String id;
    @JsonProperty("created_at")
    private String createdAt;
    private String title;
    private String message;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_email")
    private String authorEmail;
    @JsonProperty("web_url")
    private String webUrl;

    public Commit(String id, String createdAt, String title, String message, String authorName, String authorEmail, String webUrl) {
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.message = message;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.webUrl = webUrl;
    }

    public String toString(){
        return new StringJoiner(", \n", File.class.getSimpleName() + "{\n", "}")
                .add("id='" + id + "'")
                .add("created at='" + createdAt + "'")
                .add("title='" + title + "'")
                .add("message='" + message + "'")
                .add("author name='" + authorName + "'")
                .add("author email='" + authorEmail + "'")
                .add("web url='" + webUrl + "'")
                .toString();
    }
}
