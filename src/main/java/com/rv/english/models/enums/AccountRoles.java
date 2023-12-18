package com.rv.english.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum AccountRoles implements GrantedAuthority {

    USER, ADMIN, TEST, GUEST;

    @Override
    public String getAuthority() {
        return name();
    }
}
