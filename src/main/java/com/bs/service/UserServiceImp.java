package com.bs.service;

import com.bs.bean.User;
import com.bs.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by willem on 2016/10/26.
 */
@Service("userService")
public class UserServiceImp implements UserService{
    @Autowired
    private IUserDao dao;
    @Transactional
    @Override
    public User getUser(String username){
        return dao.queryByUsername(username);
    }


    @Transactional
    @Override
    public List<User> getList(){
//       return dao.queryUsers();
        return null;
    }

    @Transactional
    @Override
    public void saveUser(User user){
        dao.save(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        dao.update(user);
    }
    @Transactional
    @Override
    public void deleteUser(User user) {
        dao.delete(user);
    }


}
