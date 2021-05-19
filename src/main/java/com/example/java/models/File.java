package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class File {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("path")
    private String path;
    @JsonProperty("mode")
    private String mode;

    public File() {}

    public File(String id, String name, String type, String path, String mode) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.path = path;
        this.mode = mode;
    }

    @Override
    public String toString() {
        return new StringJoiner(", \n", "\n" + File.class.getSimpleName() + "{\n", "}")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .add("path='" + path + "'")
                .add("mode='" + mode + "'")
                .toString();
    }
}
