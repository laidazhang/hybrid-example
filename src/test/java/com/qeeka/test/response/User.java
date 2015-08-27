package com.qeeka.test.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dellpc on 2015/8/27.
 */
@XStreamAlias("user")
public class User implements Serializable {
    @XStreamAlias("user_name")
    private String userName;

    @XStreamAlias("age")
    private int age;

    @XStreamAlias("sex")
    private String sex;

    @XStreamAlias("birthday")
    private Date birthday;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
