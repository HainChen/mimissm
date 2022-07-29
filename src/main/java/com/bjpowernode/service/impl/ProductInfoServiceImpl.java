package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.ProductInfoMapper;
import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.pojo.ProductInfoExample;
import com.bjpowernode.service.ProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductInfoServiceImpl
 * @Description TODO
 * @Author hainc
 * @Date 2022/7/28 9:33
 * @Version 1.0
 **/
//商品信息
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getAll() {
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }

    @Override
    public PageInfo splitPage(int pageNum, int pagesize) {
        PageHelper.startPage(pageNum,pagesize);

        //进行pageinfo的数据封装
        //进行有条件的查询，必须创建productexample对象
        ProductInfoExample example = new ProductInfoExample();
        //设置排序，按主键降序排序，保证插入的数据显示在最前面
        example.setOrderByClause("p_id desc");
        //设置完排序后，取集合，取集合之前，设置pagehelpher
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        //将查询到的集合封装进pageinfo对象中
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);//pageinfo对list的数据自动封装到pageinfo里面

        return pageInfo;
    }
}
