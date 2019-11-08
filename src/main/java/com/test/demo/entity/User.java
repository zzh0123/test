package com.test.demo.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    private String userId;
    private String userName;
    private Integer age;
    private String headPortrait;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}
