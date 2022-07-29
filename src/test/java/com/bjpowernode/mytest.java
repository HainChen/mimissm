package com.bjpowernode;

import com.bjpowernode.mapper.AdminMapper;
import com.bjpowernode.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName mytest
 * @Description TODO
 * @Author hainc
 * @Date 2022/7/27 19:46
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class mytest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    public void tst(){
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin.getaName());
    }
}
