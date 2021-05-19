package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class CommitDiff {
    @JsonProperty("old_path")
    private String oldPath;
    @JsonProperty("new_path")
    private String newPath;
    @JsonProperty("a_mode")
    private String aMode;
    @JsonProperty("b_mode")
    private String bMode;
    @JsonProperty("new_file")
    private String newFile;
    @JsonProperty("deleted_file")
    private String deletedFile;
    private String diff;

    public CommitDiff(String oldPath, String newPath, String aMode, String bMode, String newFile, String deletedFile, String diff) {
        this.oldPath = oldPath;
        this.newPath = newPath;
        this.aMode = aMode;
        this.bMode = bMode;
        this.newFile = newFile;
        this.deletedFile = deletedFile;
        this.diff = diff;
    }


    public String toString() {
        return new StringJoiner(", \n", "\n" + CommitDiff.class.getSimpleName() + "{\n", "}")
                .add("oldPath='" + oldPath + "'")
                .add("newPath='" + newPath + "'")
                .add("aMode='" + aMode + "'")
                .add("bMode='" + bMode + "'")
                .add("newFile='" + newFile + "'")
                .add("deletedFile='" + deletedFile + "'")
                .add("diff='" + diff + "'")
                .toString();
    }
}
