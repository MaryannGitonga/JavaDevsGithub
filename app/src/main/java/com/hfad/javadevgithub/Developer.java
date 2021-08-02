package com.hfad.javadevgithub;

public class Developer {

    private String login, avatar_url, html_url;

    public Developer(String login, String git_url, String avatar_url){
        this.login = login;
        this.avatar_url = avatar_url;
        this.html_url = git_url;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }
}
