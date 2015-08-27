package com.qeeka.test.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by kimi.lai on 8/27/2015.
 */
@XmlRootElement(name = "user_list_response")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserListResponse {
    @XmlElementWrapper(name = "user_list")
    @XmlElement(name = "user")
    private List<UserResponse> userResponseList;

    @XmlElement(name = "user_name")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserResponse> getUserResponseList() {
        return userResponseList;
    }

    public void setUserResponseList(List<UserResponse> userResponseList) {
        this.userResponseList = userResponseList;
    }
}
