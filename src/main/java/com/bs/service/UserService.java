package com.bs.service;

import com.bs.bean.User;

import java.util.List;

/**
 * Created by willem on 2016/10/25.
 */
public interface UserService{

     User getUser(String username);

     List<User> getList();
     void saveUser(User user);
     void updateUser(User user);
     void deleteUser(User user);

}
