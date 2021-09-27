package cn.wulei.service.impl;

import cn.wulei.entity.ProductInfo;
import cn.wulei.entity.ProductInfoExample;
import cn.wulei.mapper.ProductInfoMapper;
import cn.wulei.service.ProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoMapper productInfoMapper;
    @Override
    public PageInfo splitPage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ProductInfoExample example=new ProductInfoExample();
        example.setOrderByClause("p_id desc");
        PageInfo<ProductInfo> pageInfo=new PageInfo<>(productInfoMapper.selectByExample(example));
        return pageInfo;
    }
}
