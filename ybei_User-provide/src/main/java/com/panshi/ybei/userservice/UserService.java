package com.panshi.ybei.userservice;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.userbean.PageInfos;
import com.panshi.ybei.userbean.UserBean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * @author 爱吃湘菜不爱吃香菜
 * @version :1.0
 * @Date :2021-7-6
 */
public interface UserService {
    /**
     * 用户登录
     * @return
     */
    Boolean login(HttpSession session,String username, String password, String code);

    /**
     * 后台查询用户信息
     * @param
     * @return
     */
    PageInfo<UserBean> selectUser(String emali, int currentPage, int pageSize);

    /**
     * 注册
     * @param userBean
     * @return
     */
    Boolean regisinsert(UserBean userBean,String emailcode);


    /**
     * 个人信息修改
     * @return
     */
    Boolean updateUser(UserBean userBean,String emailcodes);

    /**
     * 发送邮箱
     * @param email
     * @return
     */
    Boolean sendMimeMail(String email);

    /**
     * 后台修改状态
     */
    Boolean updateuser(int id ,String state);

    UserBean queryUser(String emali);
}
