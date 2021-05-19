package com.example.java.commandgroups;

import com.example.java.models.MergeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@ShellComponent
@ShellCommandGroup("MergeRequests")
public class MergeRequestsGroup {

    @Autowired
    public WebClient webClient;

    @ShellMethod("Lista as merge requests de um repositorio em um projeto")
    public String listaMergeRequests(@ShellOption(help = "Id do projeto") String id) {

        MergeRequest [] response;

        if (AuthGroup.getTOKEN() != null) {
            response = webClient
                    .method(HttpMethod.GET)
                    .uri("/projects/{proj_id}/merge_requests", id)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve().bodyToMono(MergeRequest[].class)
                    .block();
        } else {
            response = webClient
                    .method(HttpMethod.GET)
                    .uri("/projects/{proj_id}/merge_requests", id)
                    .retrieve()
                    .bodyToMono(MergeRequest[].class)
                    .block();
        }

        return String.join("\n", Arrays.toString(response));
    }
}
