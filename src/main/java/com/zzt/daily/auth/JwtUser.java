package com.zzt.daily.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by zhaotao on 2017/5/25.
 */
@Getter
@Setter
public class JwtUser implements UserDetails {

    private final long id;
    private final String username;
    private final String password;
    private final int github_id;

    public JwtUser(
        long id,
        String username,
        String password,
        int github_id
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.github_id = github_id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
