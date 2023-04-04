package com.example.demo.security;

import io.micrometer.common.util.StringUtils;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CustomSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private Object filterObject;
    private Object returnObject;
    private Object target;

    /**
     * Creates a new instance
     *
     * @param authentication the {@link Authentication} to use. Cannot be null.
     */
    public CustomSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    /**
     * Check if the user has any of the given permissions
     *
     * @param permissions the permission or permissions to check
     * @return true if the user has any of the given permissions, false otherwise
     */
    public boolean hasAnyPermission(String... permissions) {
        UserDetailsImpl authentication = (UserDetailsImpl) getPrincipal();
        for (String permission : permissions) {
            if (authentication.getPermissions()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(a -> a.equals(permission))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the user has all permissions
     *
     * @param permissions the permissions to check
     * @return true if the user has all permissions, false otherwise
     */
    public boolean hasAllPermission(String... permissions) {
        UserDetailsImpl authentication = (UserDetailsImpl) getPrincipal();
        List<String> permissionsList = Arrays.asList(permissions);
        return authentication.getPermissions()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .filter(permissionsList::contains)
                .count() == permissionsList.size();
    }

//    if (authentication.getPermissions()
//            .stream()
//                    .map(GrantedAuthority::getAuthority)
//                    .allMatch(a -> a.equals(permission)))

    /**
     * Validates if Current User is authorized for ALL given permissions
     *
     * @param permissions cannot be empty
     */
    public boolean hasPermission(String... permissions) {
        UserDetailsImpl authentication = (UserDetailsImpl) getPrincipal();
        if (!CollectionUtils.isEmpty(authentication.getPermissions())) {
            List<String> authenticationPermissions = authentication.getPermissions()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(GrantedAuthority::getAuthority)
                    .toList();

            return Arrays.stream(permissions)
                    .filter(StringUtils::isNotBlank)
                    .allMatch(authenticationPermissions::contains);
        }
        return false;
    }

    public boolean isLoggedUser(Integer id) {
        UserDetailsImpl authentication = (UserDetailsImpl) getPrincipal();
        return authentication.getId() == id;
    }

    public boolean isAnyLoggedUser(Integer... ids) {
        UserDetailsImpl authentication = (UserDetailsImpl) getPrincipal();
        return Arrays.asList(ids).contains(authentication.getId());
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getThis() {
        return target;
    }

    public void setThis(Object target) {
        this.target = target;
    }
}