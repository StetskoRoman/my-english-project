package com.rv.english.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum AccountRoles implements GrantedAuthority {

    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
