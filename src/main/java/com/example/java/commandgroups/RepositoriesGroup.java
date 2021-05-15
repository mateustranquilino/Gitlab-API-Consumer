package com.example.java.commandgroups;

import com.example.java.models.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Scanner;

@ShellComponent
@ShellCommandGroup("Repositorios")
public class RepositoriesGroup {

    @Autowired
    public WebClient webClient;

    @ShellMethod("Lista os repositorios de um usuario")
    public String listaRepositorios(@ShellOption(help = "Id do usuario") String id) {

        Repository[] response;
        Scanner sc = new Scanner(System.in);

        if (AuthGroup.getTOKEN() != null) {
            response = webClient
                    .method(HttpMethod.GET)
                    .uri("/users/{user_id}/projects", id)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve().bodyToMono(Repository[].class)
                    .block();
        } else {
            response = webClient
                    .method(HttpMethod.GET)
                    .uri("/users/{user_id}/projects", id)
                    .retrieve()
                    .bodyToMono(Repository[].class)
                    .block();
        }

        return Arrays.toString(response);
    }
}
