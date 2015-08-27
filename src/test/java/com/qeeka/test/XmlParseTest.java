package com.qeeka.test;

import com.qeeka.test.response.User1Response;
import com.qeeka.test.response.UserListResponse;
import com.qeeka.test.response.UserResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kimi.lai on 8/27/2015.
 */
public class XmlParseTest extends SpringTestWithDB {
    @Autowired
    private Marshaller marshaller;

    @Test
    public void test() throws JAXBException {
        UserResponse user = new UserResponse();
        user.setUserName("kimi");
        user.setAge(18);
        user.setSex("男");
        user.setBirthday(new Date());

        User1Response user1 = new User1Response();
        BeanUtils.copyProperties(user, user1);

        UserListResponse userListResponse = new UserListResponse();
        List<UserResponse> userResponseList = new ArrayList<>();
        userResponseList.add(user);
        userListResponse.setUserResponseList(userResponseList);
        marshaller.marshal(userListResponse, System.out);

        marshaller.marshal(user, System.out);

        marshaller.marshal(user1, System.out);
        Assert.assertTrue(1 == 1);
    }
}
