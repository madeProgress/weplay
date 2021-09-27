package cn.wulei.service;

import cn.wulei.entity.Admin;



public interface AdminService {
//    登录判断
    Admin loginAdmin(String name , String password);

    int register(Admin admin);
}
