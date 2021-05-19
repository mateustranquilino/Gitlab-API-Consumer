package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class DiffBranch{
    @JsonProperty("old_path")
    private String oldPath;

    @JsonProperty("new_path")
    private String newPath;

    private String diff;

    @JsonProperty("new_file")
    private Boolean newFile;

    @JsonProperty("renamed_file")
    private Boolean renamedFile;

    @JsonProperty("deleted_file")
    private Boolean deletedFile;

    public DiffBranch(String oldPath, String newPath, String diff, Boolean newFile, Boolean renamedFile,
            Boolean deletedFile) {
        this.oldPath = oldPath;
        this.newPath = newPath;
        this.diff = diff;
        this.newFile = newFile;
        this.renamedFile = renamedFile;
        this.deletedFile = deletedFile;
    }

    @Override
    public String toString() {
      return new StringJoiner(", \n", "\n" + DiffBranch.class.getSimpleName() + "{\n", "}")
      .add("old_path=" + oldPath)
      .add("new_path=" + newPath)
      .add("diff=" + diff)
      .add("new_file=" + newFile)
      .add("renamed_file=" + renamedFile)
      .add("deleted_file=" + deletedFile)
      .toString();
    }  

}

/* Exemplo

"diffs": {
    "old_path": "files/js/application.js",
    "new_path": "files/js/application.js",
    **"a_mode": null,
    **"b_mode": "100644",
    "diff": "--- a/files/js/application.js\n+++ b/files/js/application.js\n@@ -24,8 +24,10 @@\n //= require g.raphael-min\n //= require g.bar-min\n //= require branch-graph\n-//= require highlightjs.min\n-//= require ace/ace\n //= require_tree .\n //= require d3\n //= require underscore\n+\n+function fix() { \n+  alert(\"Fixed\")\n+}",
    "new_file": false,
    "renamed_file": false,
    "deleted_file": false
}

*/