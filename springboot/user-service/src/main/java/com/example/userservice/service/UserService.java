package com.example.userservice.service;

import com.example.userservice.dao.UserDao;
import com.example.userservice.exception.BusinessException;
import com.example.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.FindAll();
    }

    public User findById(Integer id){
        if(id==null){
            throw new BusinessException("用户id不合法");
        }
        User user = userDao.findById(id);
        if(user==null){
            throw new BusinessException("用户不存在");
        }
        return user;
    }

    public boolean addUser(User user){
        checkUser(user);
        return userDao.insert(user)>0;
    }

    public boolean updateUser(Integer id,User user){
        if (id == null || id <= 0) {
            throw new BusinessException("用户ID不合法");
        }

        User oldUser = userDao.findById(id);
        if (oldUser == null) {
            throw new BusinessException("用户不存在");
        }

        checkUser(user);

        return userDao.update(id, user) > 0;
    }

    public boolean deleteUser(Integer id){
        if (id == null || id <= 0) {
            throw new BusinessException("用户ID不合法");
        }
        User user = userDao.findById(id);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        return userDao.delete(id) > 0;
    }

    private void checkUser(User user){
        if (user == null) {
            throw new BusinessException("用户不能为空");
        }

        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new BusinessException("用户名不能为空");
        }

        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new BusinessException("密码不能为空");
        }

        if (user.getAge() != null && user.getAge() <= 0) {
            throw new BusinessException("年龄必须大于0");
        }
    }


}
