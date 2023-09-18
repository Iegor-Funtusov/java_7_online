package ua.com.alevel.persistence.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.List;
import java.util.Set;

import static ua.com.alevel.persistence.type.PermissionType.*;

@Getter
@RequiredArgsConstructor
public enum RoleType {

    PERSONAL(Set.of(PERSONAL_CREATE, PERSONAL_UPDATE, PERSONAL_DELETE, PERSONAL_READ)),
    ADMIN(Set.of(ADMIN_CREATE, ADMIN_UPDATE, ADMIN_DELETE, ADMIN_READ));

    private final Set<PermissionType> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
