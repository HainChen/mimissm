package com.bjpowernode.controller;

import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.service.ProductInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName ProductInfoAction
 * @Description TODO
 * @Author hainc
 * @Date 2022/7/28 9:36
 * @Version 1.0
 **/
@Controller
@RequestMapping("/prod")
public class ProductInfoAction {

    //每页显示的记录数
    public static final int PAGE_SIZE = 5;

    @Autowired
    ProductInfoService productInfoService;

    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request){
        List<ProductInfo> list = productInfoService.getAll();
        request.setAttribute("list",list);
        return "product";
    }

    //显示第1页的5条数据
    @RequestMapping("/split")
    public String split(HttpServletRequest request){
        //得到第1页的数据
        PageInfo pageInfo = productInfoService.splitPage(1, PAGE_SIZE);
        request.setAttribute("info",pageInfo);
        return "product";
    }

    //AJXA分页翻页处理
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(int page, HttpSession session){
        //取得page参数的页面的数据
        PageInfo info = productInfoService.splitPage(page, PAGE_SIZE);
        session.setAttribute("info",info);
    }
}
