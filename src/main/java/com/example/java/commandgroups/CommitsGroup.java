package com.example.java.commandgroups;

import com.example.java.models.Commit;
import com.example.java.models.CommitDiff;
import com.example.java.models.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@ShellComponent
@ShellCommandGroup("Commits")
public class CommitsGroup {

    @Autowired
    public WebClient webClient;

    @ShellMethod("Lista os commits em um repositório")
    public String listaCommits(@ShellOption(help = "id do repositório") String id){
        Commit[] response;
        if (AuthGroup.getTOKEN() != null) {
                response = webClient
                    .get()
                    .uri("/projects/{repository_id}/repository/commits", id)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve()
                    .bodyToMono(Commit[].class)
                    .block();
        }
        else{
            response = webClient
                    .get()
                    .uri("/projects/{repository_id}/repository/commits", id)
                    .retrieve()
                    .bodyToMono(Commit[].class)
                    .block();
        }

        return Arrays.toString(response);
    }

    @ShellMethod("Lista os commits em um repositório")
    public String listaDiffCommit(
            @ShellOption(help = "id do repositório") String idRepo,
            @ShellOption(help = "id do commit") String idCommit){

        CommitDiff[] response = webClient
                .get()
                .uri("https://gitlab.com/api/v4/projects/{repository_id}/repository/commits/{id_commit}/diff", idRepo, idCommit)
                .retrieve()
                .bodyToMono(CommitDiff[].class)
                .block();

        return Arrays.toString(response);
    }
}
