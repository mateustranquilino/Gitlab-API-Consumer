package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class Branch {
    private String name;
    private Commit lastCommit;    
    private Boolean merged;

    @JsonProperty("protected")
    private Boolean protected_;

    @JsonProperty("developers_can_push")
    private Boolean developersCanpush;

    @JsonProperty("developers_can_merge")
    private Boolean developersCanMerge;

    @JsonProperty("can_push")
    private Boolean canPush;

    @JsonProperty("default")
    private Boolean default_;

    @JsonProperty("web_url")
    private String webURL;



    public Branch(String name, Commit lastCommit, Boolean merged, Boolean protected_, Boolean developersCanpush,
            Boolean developersCanMerge, Boolean canPush, Boolean default_, String webURL) {
        this.name = name;
        this.lastCommit = lastCommit;
        this.merged = merged;
        this.protected_ = protected_;
        this.developersCanpush = developersCanpush;
        this.developersCanMerge = developersCanMerge;
        this.canPush = canPush;
        this.default_ = default_;
        this.webURL = webURL;
    }

    @Override
    public String toString() {
      return new StringJoiner(", \n", "\n" + Branch.class.getSimpleName() + "{\n", "}")
      .add("name=" + name)
      .add("last_commit=" + lastCommit)
      .add("merged=" + merged)
      .add("protected=" + protected_)
      
      .add("developersCanpush=" + developersCanpush)
      .add("developersCanMerge=" + developersCanMerge)
      .add("canPush=" + canPush)
      .add("default_=" + default_)
      .add("webURL=" + webURL)
      .toString();
    }  

}

/* Exemplo

"name": "89-update-partner-marketing-handbook-to-include-link-and-or-instructions-for-partner-hosted",
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
},
"merged": false,
"protected": false,
"developers_can_push": false,
"developers_can_merge": false,
"can_push": false,
"default": false,
"web_url": "https://gitlab.com/gitlab-com/marketing/partner-marketing/-/tree/89-update-partner-marketing-handbook-to-include-link-and-or-instructions-for-partner-hosted"
}"

*/