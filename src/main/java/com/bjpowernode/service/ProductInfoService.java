package com.bjpowernode.service;

import com.bjpowernode.pojo.ProductInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductInfoService {
    List<ProductInfo> getAll();//获取所有商品信息

    PageInfo splitPage(int pageNum,int pagesize);
}
