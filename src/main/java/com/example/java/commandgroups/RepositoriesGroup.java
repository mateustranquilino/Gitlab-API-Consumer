package com.example.java.commandgroups;

import com.example.java.models.File;
import com.example.java.models.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@ShellComponent
@ShellCommandGroup("Repositorios")
public class RepositoriesGroup {

    @Autowired
    public WebClient webClient;

    @ShellMethod("Lista os repositorios de um usuario")
    public String listaRepositorios(@ShellOption(help = "Id do usuario") String id) {

        Repository[] response;

        if (AuthGroup.getTOKEN() != null) {
            response = webClient
                    .method(HttpMethod.GET)
                    .uri("/users/{user_id}/projects", id)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve()
                    .bodyToMono(Repository[].class)
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

    @ShellMethod("Lista os arquivos e diretórios de um repositório")
    public String listaArquivosRepositorio(
            @ShellOption(help = "Id do repositório") String id,
            @ShellOption(help = "Quantidade de arquivos retornados. Default: 20", defaultValue = "20") String pages,
            @ShellOption(help = "Listar de forma recursiva", defaultValue = "false") String recursive,
            @ShellOption(help = "Path para algum subdiretorio", defaultValue = "") String path){

        File[] response;

        if (AuthGroup.getTOKEN() != null) {
            response = webClient
                    .get()
                    .uri("/projects/{id}/repository/tree?recursive={recursive}&per_page={pages}&path={path}",
                            id,recursive, pages, path)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve()
                    .bodyToMono(File[].class)
                    .block();

        } else {
            response = webClient
                    .get()
                    .uri("/projects/{id}/repository/tree?recursive={recursive}&per_page={pages}&path={path}",
                            id,recursive, pages, path)
                    .retrieve()
                    .bodyToMono(File[].class)
                    .block();
        }

        return Arrays.toString(response);
    }

    @ShellMethod("Retorna o conteudo de um arquivo do repositório")
    public String getArquivoRepositorio(
            @ShellOption(help = "Id do repositório") String id,
            @ShellOption(help = "path para o arquivo") String path){

        String response;

        if (AuthGroup.getTOKEN() != null){
            response = webClient
                    .get()
                    .uri("/projects/{id}/repository/files/{path}/raw", id, path)
                    .headers(h -> h.setBearerAuth(AuthGroup.getTOKEN()))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } else {
            response = webClient
                    .get()
                    .uri("/projects/{id}/repository/files/{path}/raw", id, path)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }

        return response;
    }
}
