package com.example.java.models;

import java.util.Arrays;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiffBetweenBranches {
    @JsonProperty("commit")
    private Commit lastCommit;

    @JsonProperty("commits")
    private Commit [] comparadedCommits;

    @JsonProperty("diffs")
    private DiffBranch [] diffs;

    public DiffBetweenBranches(Commit lastCommit, Commit [] comparadedCommits, DiffBranch [] diffs) {
        this.lastCommit = lastCommit;
        this.comparadedCommits = comparadedCommits;
        this.diffs = diffs;
    }

    @Override
    public String toString() {
      return new StringJoiner(", \n", "\n" + DiffBetweenBranches.class.getSimpleName() + "{\n", "}")
      .add("last_commit=" + lastCommit)
      .add("comparaded_commits=" + Arrays.toString(comparadedCommits))
      .add("diffs=" + Arrays.toString(diffs))
      .toString();
    }  

}

/* Exemplo

{
  "commit": {
    "id": "12d65c8dd2b2676fa3ac47d955accc085a37a9c1",
    "short_id": "12d65c8dd2b",
    "title": "JS fix",
    "author_name": "Example User",
    "author_email": "user@example.com",
    "created_at": "2014-02-27T10:27:00+02:00"
  },
  "commits": [{
    "id": "12d65c8dd2b2676fa3ac47d955accc085a37a9c1",
    "short_id": "12d65c8dd2b",
    "title": "JS fix",
    "author_name": "Example User",
    "author_email": "user@example.com",
    "created_at": "2014-02-27T10:27:00+02:00"
  }],
  "diffs": [{
    "old_path": "files/js/application.js",
    "new_path": "files/js/application.js",
    "a_mode": null,
    "b_mode": "100644",
    "diff": "--- a/files/js/application.js\n+++ b/files/js/application.js\n@@ -24,8 +24,10 @@\n //= require g.raphael-min\n //= require g.bar-min\n //= require branch-graph\n-//= require highlightjs.min\n-//= require ace/ace\n //= require_tree .\n //= require d3\n //= require underscore\n+\n+function fix() { \n+  alert(\"Fixed\")\n+}",
    "new_file": false,
    "renamed_file": false,
    "deleted_file": false
  }],
  "compare_timeout": false,
  "compare_same_ref": false
}

*/