package fish.burger.airplaneapi;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class UserAuthority implements UserDetails {
    private String username;
    private String password;
    private Set<GrantedAuthority> authoritySet;

    public UserAuthority() {
    }

    public UserAuthority(String username, String password, Set<GrantedAuthority> authoritySet) {
        this.username = username;
        this.password = password;
        this.authoritySet = authoritySet;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<GrantedAuthority> getAuthoritySet() {
        return authoritySet;
    }

    public void setAuthoritySet(Set<GrantedAuthority> authoritySet) {
        this.authoritySet = authoritySet;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritySet;
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
}
