package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Commit {
    private String id;
    @JsonProperty("short_id")
    private String shortId;
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

    public Commit(String id, String shortId, String createdAt, String title, String message, String authorName, String authorEmail, String webUrl) {
        this.id = id;
        this.shortId = shortId;
        this.createdAt = createdAt;
        this.title = title;
        this.message = message;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.webUrl = webUrl;
    }

    @Override
    public String toString() {
        return new StringJoiner(", \n", "\n" + Commit.class.getSimpleName() + "{\n", "}")
                .add("id='" + id + "'")
                .add("shortId='" + shortId + "'")
                .add("createdAt='" + createdAt + "'")
                .add("title='" + title + "'")
                .add("message='" + message + "'")
                .add("authorName='" + authorName + "'")
                .add("authorEmail='" + authorEmail + "'")
                .add("webUrl='" + webUrl + "'")
                .toString();
    }
}

