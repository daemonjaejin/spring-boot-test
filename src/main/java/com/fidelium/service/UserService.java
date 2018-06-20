package com.fidelium.service;

import com.fidelium.dao.UserMapper;
import com.fidelium.domain.Board;
import com.fidelium.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017-10-23.
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList(User user) throws Exception{
        return userMapper.getUserList(user);
    }

    public int getUserTotNum(User user){
        return userMapper.getUserTotNum(user);
    }

    public User getUser(String id){
        return userMapper.getUser(id);
    }

    public List<GrantedAuthority> readAuthority(String id){
        return userMapper.readAuthority(id);
    }

    public int insertBoard(Board board){
        return userMapper.insertBoard(board);
    }

    public User getUserConfirmList(User user){
        return userMapper.getUserConfirmList(user);
    }

}
