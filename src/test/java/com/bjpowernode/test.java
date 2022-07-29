package com.bjpowernode;

import com.bjpowernode.utils.MD5Util;
import org.junit.Test;

/**
 * @ClassName test
 * @Description TODO
 * @Author hainc
 * @Date 2022/7/27 19:32
 * @Version 1.0
 **/
public class test {

    @Test
    public void testMd5(){
        String md5 = MD5Util.getMD5("000000");
        System.out.println(md5);
    }
}
