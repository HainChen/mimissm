package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.AdminMapper;
import com.bjpowernode.pojo.Admin;
import com.bjpowernode.pojo.AdminExample;
import com.bjpowernode.service.AdminService;
import com.bjpowernode.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author hainc
 * @Date 2022/7/27 19:34
 * @Version 1.0
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {
        AdminExample example = new AdminExample();
        example.createCriteria().andANameEqualTo(name);
        List<Admin> list = adminMapper.selectByExample(example);
        if(list.size() > 0){
            Admin admin = list.get(0);
            String md5 = MD5Util.getMD5(pwd);//加密
            if(md5.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }
}
