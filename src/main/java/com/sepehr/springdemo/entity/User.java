package com.sepehr.springdemo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @Size(max = 50, min = 5, message = "ایمیل شما معتبر نیست")
    private String email;

    @Column
    @Size(min = 2, max = 50, message = "نام شما معتبر نیست")
    private String name;

    @Column(name = "last_name")
    @Size(min = 2, max = 50, message = "نام خانوادگی شما معتبر نیست")
    private String lastName;

    @Column
    @NotNull(message = "سن شما نباید خالی باشد")
    @Max(value = 100, message = "شما بسیار مسن هستید :)")
    @Min(value = 10, message = "سن شما کم است")
    private Integer age;

    @Column
    @CreationTimestamp
    private Date signupDate;

    public User(String email, String name, String lastName, Integer age) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", signupDate=" + signupDate +
                '}';
    }


}
