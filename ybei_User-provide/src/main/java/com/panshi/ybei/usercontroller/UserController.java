package com.panshi.ybei.usercontroller;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.userbean.PageInfos;
import com.panshi.ybei.userbean.UserBean;
import com.panshi.ybei.userservice.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * @author 爱吃湘菜不爱吃香菜
 * @version :1.0
 * @Date :2021-7-6
 */
@Api(tags = "秋鹏的用户接口")
@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户List接口")
    @PostMapping("/ybei/queryUser")
    @ResponseBody
    public UserBean queryUser(@RequestParam String email){
        return userService.queryUser(email);
    }
    /**
     * 前台登录
     * @return
     */
    @ApiOperation(value = "前台登录接口")
    @PostMapping("/yebi/login")
    @ResponseBody
    public Boolean login(HttpSession httpSession, @RequestParam String username, @RequestParam String password, @RequestParam String code){
        return userService.login(httpSession,username,password,code);
    }

    /**
     * 注册
     * @param userBean
     * @return
     */
    @ApiOperation(value = "注册接口")
    @GetMapping("/yebi/regis")
    @ResponseBody
   public Boolean regisinsert(UserBean userBean ,String code){
        return userService.regisinsert(userBean,code);
   }
    /**
     * 邮箱发送
     */
    @ApiOperation(value = "邮箱发送接口")
    @GetMapping("/ybei/regis/Email")
    @ResponseBody
    public Boolean email(String email){
       return userService.sendMimeMail(email);
    }
    /**
     * 后台分页查询
     * @param
     * @param currentPage 第几页比如第一页1
     * @param pageSize 分页需要查询的数量，比如10
     * @return
     */
    @ApiOperation(value = "后台用户信息接  口+分页")
    @PostMapping("/ybei/loginUser")
    @ResponseBody
    public PageInfo<UserBean> loginUser(@RequestParam("emali")String emali, @RequestParam("currentPage")int currentPage, @RequestParam("pageSize")int pageSize){
         return userService.selectUser(emali,currentPage,pageSize);
    }

    /**
     * 个人中心修改
     * @param userBean
     * @return
     */
    @ApiOperation(value = "个人中心修改接口")
    @PostMapping("/yebei/updateUser")
    @ResponseBody
    public Boolean updateUser(UserBean userBean,String emailcodes){
        return userService.updateUser(userBean,emailcodes);
    }
    @ApiOperation(value = "后台状态修改")
    @PostMapping("/yebei/updateuser")
    @ResponseBody
    public Boolean updateuser(@RequestParam int id,@RequestParam String state){
        return userService.updateuser(id,state);
    }
}
