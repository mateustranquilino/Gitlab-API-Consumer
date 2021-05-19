package com.example.java.commandgroups;

import com.example.java.models.Branch;
import com.example.java.models.DiffBetweenBranches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@ShellComponent
@ShellCommandGroup("Branches")
public class BranchesGroup {

    @Autowired
    public WebClient webClient;

    @ShellMethod("Acessa uma branch especifica em um projeto especifico")
    public String getBranch(
        @ShellOption(help = "Id do projeto") String id,
        @ShellOption(help = "Nome da branch") String name) {

        Branch response;

        if (AuthGroup.getTOKEN() != null) {
            response = webClient
                    .method(HttpMethod.GET)
                    .uri("/projects/{proj_id}/repository/branches/{name_branch}", id, name)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve().bodyToMono(Branch.class)
                    .block();
        } else {
            response = webClient
                    .method(HttpMethod.GET)
                    .uri("/projects/{proj_id}/repository/branches/{name_branch}", id, name)
                    .retrieve()
                    .bodyToMono(Branch.class)
                    .block();
        }

        return response.toString();
    }

    @ShellMethod("Lista as branches de um repositorio em um projeto")
    public String listaBranches(@ShellOption(help = "Id do projeto") String id) {

        Branch[] response;

        if (AuthGroup.getTOKEN() != null) {
            response = webClient
                    .method(HttpMethod.GET)
                    .uri("/projects/{proj_id}/repository/branches", id)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve().bodyToMono(Branch[].class)
                    .block();
        } else {
            response = webClient
                    .method(HttpMethod.GET)
                    .uri("/projects/{proj_id}/repository/branches", id)
                    .retrieve()
                    .bodyToMono(Branch[].class)
                    .block();
        }

        return String.join("\n", Arrays.toString(response));
    }

    @ShellMethod("Mostrar a diferenca entre branches")
    public String compareBranches(
        @ShellOption(help = "Id do projeto") String id, 
        @ShellOption(help = "Nome da primeira branch") String branchName1,
        @ShellOption(help = "Nome da segunda branch") String branchName2) {

            DiffBetweenBranches response;

            if (AuthGroup.getTOKEN() != null) {
                response = webClient
                        .method(HttpMethod.GET)
                        .uri("/projects/{proj_id}/repository/compare?from={branch_name_1}&to={branch_name_2}", id, branchName1, branchName2)
                        .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                        .retrieve().bodyToMono(DiffBetweenBranches.class)
                        .block();
            } else {
                response = webClient
                        .method(HttpMethod.GET)
                        .uri("/projects/{proj_id}/repository/compare?from={branch_name_1}&to={branch_name_2}", id, branchName1, branchName2)
                        .retrieve()
                        .bodyToMono(DiffBetweenBranches.class)
                        .block();
            }

            return response.toString();

        }
}
