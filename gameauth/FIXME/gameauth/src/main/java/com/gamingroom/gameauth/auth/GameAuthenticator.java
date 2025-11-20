package com.gamingroom.gameauth.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> 
{
    private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );

    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException 
    {
        // Verify username exists & password is correct
        if (VALID_USERS.containsKey(credentials.getUsername()) 
                && "password".equals(credentials.getPassword())) 
        {
            // Build a new GameUser with id, username, and roles
            Set<String> roles = VALID_USERS.get(credentials.getUsername());
            int id = (int) (Math.random() * 100); // temporary random ID
            GameUser user = new GameUser(id, credentials.getUsername(), roles);

            return Optional.of(user);
        }

        return Optional.empty();
    }

}
