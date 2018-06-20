package com.fidelium.dao;

import com.fidelium.domain.Board;
import com.fidelium.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017-10-23.
 */
public interface UserMapper {

    public List<User> getUserList(User user) throws Exception;
    public int getUserTotNum(User user);

    public User getUser(String id);
    public List<GrantedAuthority> readAuthority(String id);

    public int userCheck(User user);
    public User readUser(String id);
    public void createUser(User user);
    public void createAuthority(User user);
    public void deleteUser(String id);
    public void deleteAuthority(String id);
    public int realDeleteUser(String id);
    public int updateUser(User user);
    public int userPassUpdate(User user);

    public int insertBoard(Board board);

    public User getUserConfirmList(User user);

}
