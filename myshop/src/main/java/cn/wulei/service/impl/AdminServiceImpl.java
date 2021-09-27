package cn.wulei.service.impl;

import cn.wulei.entity.Admin;
import cn.wulei.entity.AdminExample;
import cn.wulei.mapper.AdminMapper;
import cn.wulei.service.AdminService;
import cn.wulei.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin loginAdmin(String name, String password) {
        try {
            AdminExample example=new AdminExample();
//        添加条件
            example.createCriteria().andANameEqualTo(name);
            System.out.println("进入service"+name+password);
            List<Admin> list=adminMapper.selectByExample(example);
            System.out.println("查询完成:"+list.size());
            if (list.size()>0){
                Admin admin=list.get(0);
                String mipwd= MD5Util.getMD5(password);
                if (admin.getaPass().equals(mipwd)){
                    return admin;
                }
            }
            System.out.println("返回空！！");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public int register(Admin admin) {
        String name=admin.getaName();
        String pws=MD5Util.getMD5(admin.getaPass());
        admin.setaPass(pws);
        int num=-1;
        if (name!=""||pws!=""){
            num=adminMapper.insert(admin);
        }
        return num;
    }
}
