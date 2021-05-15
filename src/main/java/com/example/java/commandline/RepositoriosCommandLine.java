package com.example.java.commandline;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.reactive.function.client.WebClient;

@ShellComponent
@ShellCommandGroup("Repositorios")
public class RepositoriosCommandLine {


    public WebClient.Builder webClient;

    @ShellMethod("Lista os repositorios de um usuario")
    public String listaRepositorios(
            @ShellOption(help = "Nome do usuario") String user) {

        // TODO
        String response = null;
        
        return response;
    }
}
