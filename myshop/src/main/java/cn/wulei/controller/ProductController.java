package cn.wulei.controller;

import cn.wulei.entity.ProductInfo;
import cn.wulei.service.ProductInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("prod")
public class ProductController {

    final static int PAGE_SIZE=6;

    @Autowired
    ProductInfoService productInfoService;


    @RequestMapping("split")
    public String split(HttpServletRequest request){
       PageInfo<ProductInfo> pageInfo= productInfoService.splitPage(1,PAGE_SIZE);
       request.setAttribute("info",pageInfo);

        return "product";
    }
    @ResponseBody
    @RequestMapping("ajaxSplit")
    public void ajaxSplit(String page, HttpSession session){

        PageInfo<ProductInfo> pageInfo= productInfoService.splitPage(Integer.valueOf(page),PAGE_SIZE);

        session.setAttribute("info",pageInfo);
    }

}
