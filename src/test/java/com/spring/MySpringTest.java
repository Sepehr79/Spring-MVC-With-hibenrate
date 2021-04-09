package com.spring;

import com.sepehr.springdemo.dao.DAO;
import com.sepehr.springdemo.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-mvc-hibernate-servlet.xml")
public class MySpringTest{

    @Autowired
    private DAO<User> userDao;

    @After
    public void resetDatabase(){
        userDao.reset();
    }

    @Test
    public void testInsert(){
        String email = "sepehrmsm1379@gmail.com";

        User user = new User(email, "sepehr", "mollaei", 20);

        userDao.save(user);

        User insertedUser = userDao.getReferencesBySpecialValue(email);

        Assert.assertNotNull(insertedUser);

        Assert.assertEquals(insertedUser.getName(), "sepehr");
    }

    @Test
    public void testGetAllUsers(){
        User user1 = new User("se@gmail.com", "sepehr", "mollaei", 20);
        User user2 = new User("comonda@gmail.com", "sepehr", "mollaei", 20);
        User user3 = new User("lary2yaldi@gmail.com", "sepehr", "mollaei", 20);

        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);

        List<User> users = userDao.getReferences();

        Assert.assertEquals(users.size(), 3);
    }

    @Test
    public void testUpdate(){
        User user = new User("se@gmail.com", "sepehr", "mollaei", 20);

        userDao.save(user);

        User insertedUser = userDao.getReferencesBySpecialValue("se@gmail.com");

        Assert.assertEquals(user.getName(), "sepehr");

        insertedUser.setName("ahmad");

        userDao.update(insertedUser);

        User updatedUser = userDao.getReferencesBySpecialValue("se@gmail.com");

        Assert.assertEquals(updatedUser.getName(), "ahmad");

        List<User> users = userDao.getReferences();

        Assert.assertEquals(users.size(), 1);
    }

    @Test
    public void testDeleteUser(){
        User user = new User("se@gmail.com", "sepehr", "mollaei", 20);

        userDao.save(user);

        User insertedUser = userDao.getReferencesBySpecialValue("se@gmail.com");

        userDao.delete(insertedUser);

        User deletedUser = userDao.getReferencesBySpecialValue("se@gmail.com");

        Assert.assertNull(deletedUser);
    }

}
