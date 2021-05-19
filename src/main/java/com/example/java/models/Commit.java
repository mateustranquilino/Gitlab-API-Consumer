package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Commit {
    private String id;
    
    @JsonProperty("short_id")
    private String shortId;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("parents_id")
    private String parentsId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("message")
    private String message;

    @JsonProperty("author_name")
    private String authorName;

    @JsonProperty("author_email")
    private String authorEmail;
    
    @JsonProperty("authored_date")
    private String authoredDate;

    @JsonProperty("committer_name")
    private String committerName;

    @JsonProperty("committer_email")
    private String commiterEmail;

    @JsonProperty("committer_date")
    private String commiterDate;

    @JsonProperty("web_url")
    private String webURL;

    public Commit(String id, String createdAt, String shortId, String parentsId, String title, String message,
        String authorName, String authorEmail, String authoredDate, String committerName, String commiterEmail,
        String commiterDate, String webURL) {
      this.id = id;
      this.shortId = shortId;
      this.createdAt = createdAt;      
      this.parentsId = parentsId;
      this.title = title;
      this.message = message;
      this.authorName = authorName;
      this.authorEmail = authorEmail;
      this.authoredDate = authoredDate;
      this.committerName = committerName;
      this.commiterEmail = commiterEmail;
      this.commiterDate = commiterDate;
      this.webURL = webURL;
    }

    @Override
    public String toString() {
      return new StringJoiner(", \n\t", Commit.class.getSimpleName() + "{\n\t", "\n\t}")
      .add("id=" + id)
      .add("shortId=" + shortId)
      .add("createdAt=" + createdAt)
      .add("parentsId=" + parentsId)
      .add("title=" + title)
      .add("message=" + message)
      .add("authorName=" + authorName)
      .add("authorEmail=" + authorEmail)
      .add("authoredDate=" + authoredDate)
      .add("committerName=" + committerName)
      .add("commiterEmail=" + commiterEmail)
      .add("commiterDate=" + commiterDate)
      .add("webURL=" + webURL)
      .toString();
    }    
}

/* Exemplo 

"commit": {
  "id": "ec11531433139bde26f04bcfab421e9ade8bad09",
  "short_id": "ec115314",
  "created_at": "2020-12-04T19:51:38.000+00:00",
  "parent_ids": null,
  "title": "Update README.md",
  "message": "Update README.md",
  "author_name": "Sara E. Davila",
  "author_email": "sdavila@gitlab.com",
  "authored_date": "2020-12-04T19:51:38.000+00:00",
  "committer_name": "Sara E. Davila",
  "committer_email": "sdavila@gitlab.com",
  "committed_date": "2020-12-04T19:51:38.000+00:00",
  "web_url": "https://gitlab.com/gitlab-com/marketing/partner-marketing/-/commit/ec11531433139bde26f04bcfab421e9ade8bad09"
}



*/
