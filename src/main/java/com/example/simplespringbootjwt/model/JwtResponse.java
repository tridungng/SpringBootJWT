package com.example.simplespringbootjwt.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    public static final long serialVersionUID = 12313123123L;
    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }
}
