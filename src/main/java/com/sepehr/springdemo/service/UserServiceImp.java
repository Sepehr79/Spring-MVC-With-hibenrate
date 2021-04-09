package com.sepehr.springdemo.service;

import com.sepehr.springdemo.dao.DAO;
import com.sepehr.springdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private DAO<User> userDAO;

    @Autowired
    public void setUserDAO(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getUsers() {
        return userDAO.getReferences();
    }

    public void addUser(User user) {
        userDAO.saveOrUpdate(user);
    }

    public User getUserById(Integer id) {
        return userDAO.getReferenceById(id);
    }

    public void updateUser(User user){
        userDAO.update(user);
    }
}
