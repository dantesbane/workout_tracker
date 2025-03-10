package com.workout.befit.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class User implements UserDetails {
    public User(String username2, String password2) {
        this.username=username2;
        this.password=password2;
        this.workoutroutinesid=new ArrayList<String>();
        this.roles=new ArrayList<String>();
        
    }

    @Id
    private String id;
    
    @NonNull @UniqueElements
    private String username;
    
    @NonNull
    private String password;


    //need to allow each user to have multiple workout routines
    private List<String> workoutroutinesid;

    private List<String> roles;
    
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Give all users ROLE_USER by default
        return List.of(new SimpleGrantedAuthority("ROLE_User"));
    }
    
}
