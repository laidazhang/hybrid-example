package com.qeeka.test.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kimi.lai on 8/27/2015.
 */
@XmlRootElement(name = "user1")
@XmlAccessorType(XmlAccessType.FIELD)
public class User1Response {
    @XmlElement(name = "user_name")
    private String userName;

    @XmlElement(name = "age")
    private int age;

    @XmlElement(name = "sex")
    private String sex;

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
}
