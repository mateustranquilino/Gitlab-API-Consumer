package com.example.java.commandgroups;

import com.example.java.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@ShellComponent
@ShellCommandGroup("Usuarios")
public class UsersGroup {

    @Autowired
    private WebClient webClient;

    @ShellMethod("Acessa um usuario pelo username do gitlab")
    public String getUsuario(@ShellOption(help = "Nome do usuario") String user) {

        User[] response = webClient
                .method(HttpMethod.GET)
                .uri("/users?username={username}", user)
                .retrieve()
                .bodyToMono(User[].class)
                .block();

        return Arrays.toString(response);
    }

}
