package cn.wulei.service;


import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductInfoService {

    PageInfo splitPage(Integer pageNum,Integer pageSize);
}
