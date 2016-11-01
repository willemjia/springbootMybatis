package com.bs.dao;

import com.bs.bean.User;

/**
 * Created by willem on 2016/10/31.
 */
public interface IUserDao {
    User queryByUsername(String username);
    void save(User user);
    void update(User user);
    void delete(User user);


}
