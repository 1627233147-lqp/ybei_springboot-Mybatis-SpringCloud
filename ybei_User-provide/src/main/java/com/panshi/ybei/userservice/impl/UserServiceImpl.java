package com.panshi.ybei.userservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panshi.ybei.userbean.UserBean;
import com.panshi.ybei.usermapper.UserMapper;
import com.panshi.ybei.userservice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.beans.SimpleBeanInfo;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author 爱吃湘菜不爱吃香菜
 * @version :1.0
 * @Date :2021-7-6
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private JavaMailSender mailSender;//一定要用@Autowired
   @Value("${spring.mail.username}")
     private String from;



    /**
     * 随机生成6位数的验证码
     * @return String code
     */
    public String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    /**
     * md5解密
     * @param password
     * @return
     */
     public static String Md5(String password){
         char[] a = password.toCharArray();
         for (int i = 0; i < a.length; i++){
             a[i] = (char) (a[i] ^ 't');
         }
         String s = new String(a);
         return s;
     }
        /**
         * 前台登录
         * @return 用户list
         */
    @Override
    public Boolean login(HttpSession session,String username, String password, String code){
        UserBean userBean = userMapper.queryUser(username);
               if (userBean==null){
                   return false;
               }
        /**
         * 判断验证码是否正确
         */
        if (!code.equals(redisTemplate.opsForValue().get("code"))){
            return false;
        }
        if (!userBean.getU_password().equals(password)){
             return false;
        }
        log.info("登录成功");
        session.setAttribute("user",userBean);
        userMapper.login(username,password,code);
        return true;
    }




    /**
     * 后台查询所有用户
     * @param currentPage 第几页，比如第一页1
     *  * @param pageSize  分页需要查询的数量，比如10
     * @return 用户list
     */
    @Override
    public PageInfo<UserBean> selectUser(String emali, int currentPage, int pageSize) {
        log.info("currentPage={}，pageSize={}",currentPage,pageSize);
        PageHelper.startPage(currentPage, pageSize,true);
        List<UserBean> list =userMapper.selectUser(emali,currentPage,pageSize);
        log.info("list={}",list);
        System.out.println(list);
        PageInfo<UserBean> pageInfo = new PageInfo<>(list);
//        long total=pageInfo.getTotal();
//        //获取当前第几页
//        int pageNum=pageInfo.getPageNum();
//        //共多少页
//        int pages=pageInfo.getPages();

        return pageInfo;
    }
@Override
    public Boolean sendMimeMail(String email){
        if (email==null){
            return false;
        }
        SimpleMailMessage simpleMailMessage =new SimpleMailMessage();
        simpleMailMessage.setSubject("秋鹏测试邮箱验证码");
        String code =randomCode();
        redisTemplate.opsForValue().set(email,code,90, TimeUnit.SECONDS);
         simpleMailMessage.setText("欢迎注册有贝口腔网您的验证码是"+"<"+code+">请及时查看");
         simpleMailMessage.setTo(email);
         simpleMailMessage.setFrom(from);
         mailSender.send(simpleMailMessage);
          return true;

    }
    public  static  void shengdanshu() {
        int level = 10;
        int rootLevel = 2;
        int spaceNum = level - 1;

        for (int i = 1; i <= level; i++) {
            spaceNum--;
            for (int g = 0; g <= spaceNum; g++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= ((i * 2) - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.out.println("    圣诞快乐**");

        for (int i = 1; i <= rootLevel; i++) {
            for (int g = 1; g < level; g++) {
                System.out.print(" ");
            }
            System.out.print("?\n");
        }
    }

    @Override
    public Boolean updateuser(int id, String state) {
        userMapper.updateuser(id, state);
        return true;
    }

    @Override
    public UserBean queryUser(String emali) {
        return userMapper.queryUser(emali);
    }

    /**
     * 注册
     * @param userBean
     * @return
     */
    @Override
    public Boolean regisinsert(UserBean userBean,String emailcode){


        log.info("userBean={}",userBean);
      /*  UserBean u =  userMapper.login(userBean.getYbei_userName(),userBean.getU_password());*/
        UserBean u = queryUser(userBean.getU_mailbox());
        log.info("u={}",u);
          if (userBean==null){
             return  false;
          }
          String code = redisTemplate.opsForValue().get(userBean.getU_mailbox());
        if (!userBean.getU_mailbox().equals(u.getU_mailbox())){
            userMapper.regisinsert(u);
            if (emailcode.equals(code)){
                return true;
            }
        }
        return false;
    }

    /**
     * 个人信息修改
     * @param userBean
     * @return
     */
    @Override
    public Boolean updateUser(UserBean userBean,String emailcodes) {
        if (sendMimeMail(userBean.getU_mailbox())){
            String emailcode =redisTemplate.opsForValue().get(userBean.getU_mailbox());
            if (emailcodes.equals(emailcode)){
                userMapper.updateUser(userBean);
                return true;
            }
        }
        return false;
    }

}
