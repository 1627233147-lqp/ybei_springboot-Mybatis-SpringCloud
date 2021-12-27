package com.panshi.ybei.usermapper;

import com.panshi.ybei.userbean.UserBean;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 爱吃湘菜不爱吃香菜
 */
@Mapper
public interface UserMapper {
    /**
     * 前台登录
     * @return 用户list
     */
    void login(String username,String password,String code);
    /**
     * 用户注册
     */
    void regisinsert(UserBean userBean);
    /**
     * 用户List
     * @return
     */
    UserBean queryUser(String emali);
    /**
     * 后台搜索框查询用户
     * @return 用户list
     */
    List<UserBean> selectUser(String emali, int currentPage, int pageSize);

    /**
     * 个人信息修改
     * @param userBean
     */

    void updateUser(UserBean userBean);

    /**
     * 后台修改状态
     */
     void updateuser(int id ,String state);



}
