package com.nmz.accounting.auther.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LoginUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 3816734035116350605L;

    private SysUserEntity user;

    private List<String> permissions;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //把permissions中String类型的权限信息封装成SimpleGrantedAuthority对象
        if (Objects.nonNull(permissions)) {
            return permissions.stream()
                    .map(SimpleGrantedAuthority::new)
                    .toList();
        } else
            return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
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

    public LoginUser() {
    }

    public LoginUser(SysUserEntity user) {
        this.user = user;
    }

    public LoginUser(SysUserEntity user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    public long getId() {
        return user.getUserId();
    }

    public String getUserName() {
        return user.getUserName();
    }

    public SysUserEntity getUser() {
        return user;
    }

    public void setUser(SysUserEntity user) {
        this.user = user;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
