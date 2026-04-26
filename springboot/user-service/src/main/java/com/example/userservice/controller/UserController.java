package com.example.userservice.controller;

import com.example.userservice.common.Result;
import com.example.userservice.dao.UserDao;
import com.example.userservice.pojo.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Result<List<User>> findAll() {
        return Result.success(userService.findAll());
    }

    @GetMapping("/users/{id}")
    public Result<User> findById(@PathVariable Integer id) {
        return Result.success(userService.findById(id));
    }

    @PostMapping("/users")
    public Result<String> add(@RequestBody User user){
        boolean flag = userService.addUser(user);
        return flag?Result.success("新增成功"):Result.error("新增失败");
    }

    @PutMapping("/users/{id}")
    public Result<String> update(@PathVariable Integer id,@RequestBody User user){
        boolean flag = userService.updateUser(id,user);
        return flag?Result.success("修改成功"):Result.error("修改失败");
    }

    @DeleteMapping("/users/{id}")
    public Result<String> delete(@PathVariable Integer id){
        boolean flag = userService.deleteUser(id);
        return flag?Result.success("删除成功"):Result.error("删除失败");
    }
}
