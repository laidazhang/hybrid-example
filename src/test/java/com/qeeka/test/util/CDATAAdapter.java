package com.qeeka.test.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by dellpc on 2015/8/27.
 */
public class CDATAAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String v) throws Exception {
        return "<![CDATA[" + v + "]]>";
    }

    @Override
    public String marshal(String v) throws Exception {
        return null;
    }
}
