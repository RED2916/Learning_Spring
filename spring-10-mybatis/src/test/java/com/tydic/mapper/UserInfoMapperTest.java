package com.tydic.mapper;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserInfoMapperTest extends TestCase {

    public void testSignInCheak() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserInfoMapperImpl userInfoMapper = context.getBean("userInfoMapper", UserInfoMapperImpl.class);
        System.out.println(userInfoMapper.getSingInCheck(1, "123"));
    }
}