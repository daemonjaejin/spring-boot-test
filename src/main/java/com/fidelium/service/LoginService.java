package com.fidelium.service;

import com.fidelium.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

/**
 * Created by Administrator on 2017-10-24.
 */
public interface LoginService extends UserDetailsService {

    public Collection<GrantedAuthority> getAuthorities(String username);
    public int userCheck(User user);
    public User readUser(String id);
    public int createUser(User user);
    public int updateUser(User user);
    public void deleteUser(String id);
    public int realDeleteUser(String id);
    public PasswordEncoder passwordEncoder();

    public int userPassUpdate(User user);

}
