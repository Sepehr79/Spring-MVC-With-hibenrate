package com.sepehr.springdemo.service;

import com.sepehr.springdemo.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public void addUser(User user);

    User getUserById(Integer id);

    void delete(User user);
}
