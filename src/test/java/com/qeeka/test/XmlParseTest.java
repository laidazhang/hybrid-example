package com.qeeka.test;

import com.qeeka.test.response.User1Response;
import com.qeeka.test.response.UserListResponse;
import com.qeeka.test.response.UserResponse;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.sax.SAXResult;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
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
    public void test() throws JAXBException, IOException {
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
        userListResponse.setUserName("kimitest");
        userListResponse.setUserResponseList(userResponseList);

        XMLSerializer serializer = getXMLSerializer();

        // marshal using the Apache XMLSerializer
        SAXResult result = new SAXResult( serializer.asContentHandler() );

        marshaller.marshal(userListResponse, result);

        System.out.println(result.getHandler().toString());

        //marshaller.marshal(userListResponse, System.out);

        //marshaller.marshal(user, System.out);

        //marshaller.marshal(user1, System.out);
        //Assert.assertTrue(1 == 1);
    }

    private static XMLSerializer getXMLSerializer() {
        // configure an OutputFormat to handle CDATA
        OutputFormat of = new OutputFormat();

        // specify which of your elements you want to be handled as CDATA.
        // The use of the '^' between the namespaceURI and the localname
        // seems to be an implementation detail of the xerces code.
        // When processing xml that doesn't use namespaces, simply omit the
        // namespace prefix as shown in the third CDataElement below.
        of.setCDataElements(
                new String[]{"^user user_name",   //
                        "^age"});   //

        // set any other options you'd like
        of.setPreserveSpace(true);
        of.setIndenting(true);
        // create the serializer
        XMLSerializer serializer = new XMLSerializer(of);

        serializer.setOutputByteStream(System.out);

        /*final StringWriter writer = new StringWriter();
        serializer.setOutputCharStream(writer);
        String xmlString = writer.getBuffer().toString();*/


        return serializer;
    }
}
