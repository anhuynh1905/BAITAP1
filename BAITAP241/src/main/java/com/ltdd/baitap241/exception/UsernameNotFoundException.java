package com.ltdd.baitap241.exception;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String username) {
        super(username + " not found");
    }
}
