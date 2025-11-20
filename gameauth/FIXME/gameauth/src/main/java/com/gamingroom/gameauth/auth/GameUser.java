package com.gamingroom.gameauth.auth;

import java.security.Principal;
import java.util.Set;

public class GameUser implements Principal {

    private final int id;
    private final String name;
    private final Set<String> roles;

    public GameUser(int id, String name, Set<String> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
