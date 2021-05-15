package com.example.java.commandgroups;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@ShellCommandGroup("Autenticação")
public class AuthGroup {

    private static String TOKEN;

    public static String getTOKEN() {
        return TOKEN;
    }

    public static void setTOKEN(String TOKEN) {
        AuthGroup.TOKEN = TOKEN;
    }

    @ShellMethod("Fazer login")
    public String login(@ShellOption(help = "Personal token") String token){
        setTOKEN(token);
        return "Login realizado";
    }

    @ShellMethod("Fazer logout")
    public String logout(){
        setTOKEN(null);
        return "Logout realizado";
    }

}
