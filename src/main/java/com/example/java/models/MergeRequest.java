package com.example.java.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.StringJoiner;

public class MergeRequest {
    private String id;
    private String iid;

    @JsonProperty("project_id")
    private String projectId;
    
    private String title;

    private String description;

    private String state;

    @JsonProperty("merged_by")
    private User mergedBy;

    @JsonProperty("merged_at")
    private String mergedAt;

    @JsonProperty("closed_by")
    private User closedBy;

    @JsonProperty("closed_at")
    private String closedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("target_branch")
    private String targetBranch;

    @JsonProperty("source_branch")
    private String sourceBranch;

    private User author;
    
    private User assignee;

    private User [] assignees;

    private User [] reviewers;
    
    @JsonProperty("source_project_id")
    private String sourceProjectId;

    @JsonProperty("target_project_id")
    private String targetProjectId;

    private String [] labels;

    @JsonProperty("work_in_progress")
    private Boolean workInProgress;

    public MergeRequest(
            String id, String iid, String projectId, String title, String description, String state,
            User mergedBy, String mergedAt, User closedBy, String closedAt, String createdAt, String updatedAt,
            String targetBranch, String sourceBranch, User author, User assignee, User[] assignees, User[] reviewers,
            String sourceProjectId, String targetProjectId, String[] labels, Boolean workInProgress) {

        this.id = id;
        this.iid = iid;
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.state = state;
        this.mergedBy = mergedBy;
        this.mergedAt = mergedAt;
        this.closedBy = closedBy;
        this.closedAt = closedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.targetBranch = targetBranch;
        this.sourceBranch = sourceBranch;
        this.author = author;
        this.assignee = assignee;
        this.assignees = assignees;
        this.reviewers = reviewers;
        this.sourceProjectId = sourceProjectId;
        this.targetProjectId = targetProjectId;
        this.labels = labels;
        this.workInProgress = workInProgress;
    }

    @Override
    public String toString() {
        return new StringJoiner(", \n", "\n\n" + MergeRequest.class.getSimpleName() + "{\n", "}")
                .add("id='" + id + "'")
                .add("iid='" + iid + "'")
                .add("projectId='" + projectId + "'")
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .add("state='" + state + "'")
                .add("mergedBy=" + mergedBy)
                .add("mergedAt='" + mergedAt + "'")
                .add("closedBy=" + closedBy)
                .add("closedAt='" + closedAt + "'")
                .add("createdAt='" + createdAt + "'")
                .add("updatedAt='" + updatedAt + "'")
                .add("targetBranch='" + targetBranch + "'")
                .add("sourceBranch='" + sourceBranch + "'")
                .add("author=" + author)
                .add("assignee=" + assignee)
                .add("assignees=" + Arrays.toString(assignees))
                .add("reviewers=" + Arrays.toString(reviewers))
                .add("sourceProjectId='" + sourceProjectId + "'")
                .add("targetProjectId='" + targetProjectId + "'")
                .add("labels=" + Arrays.toString(labels))
                .add("workInProgress=" + workInProgress)
                .toString();
    }


}

/* Exemplo 

[
  {
    
    "milestone": {
      "id": 5,
      "iid": 1,
      "project_id": 3,
      "title": "v2.0",
      "description": "Assumenda aut placeat expedita exercitationem labore sunt enim earum.",
      "state": "closed",
      "created_at": "2015-02-02T19:49:26.013Z",
      "updated_at": "2015-02-02T19:49:26.013Z",
      "due_date": "2018-09-22",
      "start_date": "2018-08-08",
      "web_url": "https://gitlab.example.com/my-group/my-project/milestones/1"
    },
    "merge_when_pipeline_succeeds": true,
    "merge_status": "can_be_merged",
    "sha": "8888888888888888888888888888888888888888",
    "merge_commit_sha": null,
    "squash_commit_sha": null,
    "user_notes_count": 1,
    "discussion_locked": null,
    "should_remove_source_branch": true,
    "force_remove_source_branch": false,
    "allow_collaboration": false,
    "allow_maintainer_to_push": false,
    "web_url": "http://gitlab.example.com/my-group/my-project/merge_requests/1",
    "references": {
      "short": "!1",
      "relative": "my-group/my-project!1",
      "full": "my-group/my-project!1"
    },
    "time_stats": {
      "time_estimate": 0,
      "total_time_spent": 0,
      "human_time_estimate": null,
      "human_total_time_spent": null
    },
    "squash": false,
    "task_completion_status":{
      "count":0,
      "completed_count":0
    }
  }
]

*/
