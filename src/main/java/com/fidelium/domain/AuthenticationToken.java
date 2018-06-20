package com.fidelium.domain;

import java.util.Collection;

/**
 * Created by Administrator on 2017-10-23.
 */
public class AuthenticationToken extends Result{

    private String id;
    private Collection authorities;
    private String token;

    public AuthenticationToken(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public AuthenticationToken(String title, String contents, String id, Collection authorities, String token){
        this.title = title;
        this.contents = contents;
        this.id = id;
        this.authorities = authorities;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection authorities) {
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
