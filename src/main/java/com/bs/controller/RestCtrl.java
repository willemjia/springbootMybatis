package com.bs.controller;

import com.bs.bean.User;
import com.bs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by willem on 2016/10/18.
 */
@RestController
@RequestMapping("/user")
public class RestCtrl {

    @Autowired
    @Qualifier("userService")
    private UserService userService;
    private Logger log= LoggerFactory.getLogger(RestCtrl.class);

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public User getUser(@RequestBody User user){
        User user2=userService.getUser(user.getUsername());
        return user2;
    }
    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    public List<User> getList(){
        log.info("从数据库读取用户信息");
        List<User> users = userService.getList();
        return users;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,String> save(@RequestBody User user){
        log.info("============================新增用户");
        Map<String,String> map=new HashMap<String,String>();
        try {
            userService.saveUser(user);
            map.put("status","success");
        } catch (Exception e) {
            map.put("status",e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping(value="/update",method=RequestMethod.POST)
    public Map<String,String> update(@RequestBody User user){
        log.info("============================修改用户");
        Map<String,String> map=new HashMap<String,String>();
        try {
            userService.updateUser(user);
            map.put("status","success");
        } catch (Exception e) {
            map.put("status",e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    public Map<String,String> delete(@RequestBody User user){
        log.info("============================删除用户");
        Map<String,String> map=new HashMap<String,String>();
        try {
            userService.deleteUser(user);
            map.put("status","success");
        } catch (Exception e) {
            map.put("status",e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
}
