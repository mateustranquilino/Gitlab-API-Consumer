package com.example.java.commandgroups;

import com.example.java.models.Commit;
import com.example.java.models.CommitDiff;
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

    @ShellMethod("Exibe diff de um commit em um repositório")
    public String exibeDiffCommit(
            @ShellOption(help = "id do repositório") String idRepo,
            @ShellOption(help = "id do commit") String idCommit){
        CommitDiff[] response;
        if (AuthGroup.getTOKEN() != null) {
            response = webClient
                    .get()
                    .uri("/projects/{repository_id}/repository/commits/{id_commit}/diff", idRepo, idCommit)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve()
                    .bodyToMono(CommitDiff[].class)
                    .block();
        }else {
            response = webClient
                    .get()
                    .uri("/projects/{repository_id}/repository/commits/{id_commit}/diff", idRepo, idCommit)
                    .retrieve()
                    .bodyToMono(CommitDiff[].class)
                    .block();
        }

        return Arrays.toString(response);
    }

    @ShellMethod("Exibe um commit de um repositório")
    public String exibeCommit(
            @ShellOption(help = "id do repositório") String idRepo,
            @ShellOption(help = "id do commit") String idCommit){

        Commit response;
        if (AuthGroup.getTOKEN() != null) {
            response = webClient
                    .get()
                    .uri("/projects/{repository_id}/repository/commits/{commit_id}", idRepo, idCommit)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve()
                    .bodyToMono(Commit.class)
                    .block();
        }
        else{
            response = webClient
                    .get()
                    .uri("/projects/{repository_id}/repository/commits/{commit_id}", idRepo, idCommit)
                    .retrieve()
                    .bodyToMono(Commit.class)
                    .block();
        }

        return response.toString();
    }
}
