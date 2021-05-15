package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Repository {
    private long id;
    private String description;
    private String name;
    private String visibility;
    @JsonProperty("forks_count")
    private String forksCount;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("last_activity_at")
    private String lastActivityAt;
    @JsonProperty("ssh_url_to_repo")
    private String sshURLToRepo;
    @JsonProperty("http_url_to_repo")
    private String httpURLRoRepo;
    @JsonProperty("web_url")
    private String webURL;

    public Repository(long id, String description, String name, String visibility, String forksCount,
                      String createdAt, String lastActivityAt, String sshURLToRepo, String httpURLRoRepo, String webURL) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.visibility = visibility == null ? "public" : visibility;
        this.forksCount = forksCount;
        this.createdAt = createdAt;
        this.lastActivityAt = lastActivityAt;
        this.sshURLToRepo = sshURLToRepo;
        this.httpURLRoRepo = httpURLRoRepo;
        this.webURL = webURL;
    }

    @Override
    public String toString() {
        return new StringJoiner(", \n", Repository.class.getSimpleName() + "{\n", "}")
                .add("id=" + id)
                .add("description='" + description + "'")
                .add("name='" + name + "'")
                .add("visibility='" + visibility + "'")
                .add("forksCount='" + forksCount + "'")
                .add("createdAt='" + createdAt + "'")
                .add("lastActivityAt='" + lastActivityAt + "'")
                .add("sshURLToRepo='" + sshURLToRepo + "'")
                .add("httpURLRoRepo='" + httpURLRoRepo + "'")
                .add("webURL='" + webURL + "'")
                .toString();
    }

}
