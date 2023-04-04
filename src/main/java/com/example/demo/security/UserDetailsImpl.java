package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private final Integer id;

    private final String username;

    private final String email;

    @JsonIgnore
    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    private Collection<? extends GrantedAuthority> permissions;

    public UserDetailsImpl(Integer id, String username, String email, String password,
                           Collection<? extends GrantedAuthority> authorities, Collection<? extends GrantedAuthority> permissions) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.permissions = permissions;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        List<GrantedAuthority> permissions = user.getRoles().stream().filter(Objects::nonNull)
                .map(Role::getPermissions).flatMap(Collection::stream)
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());

        System.out.println("User: " + user.toString());
        System.out.println("Permissions: " + permissions.stream().map(GrantedAuthority::toString).collect(Collectors.joining(",")));
        System.out.println("Authorities: " + authorities.stream().map(GrantedAuthority::toString).collect(Collectors.joining(",")));
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities,
                permissions);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

    public Collection<? extends GrantedAuthority> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<? extends GrantedAuthority> permissions) {
        this.permissions = permissions;
    }
}
