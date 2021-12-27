package com.panshi.ybei.controller;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.bean.MessageBean;
import com.panshi.ybei.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.dc.pr.PRError;

import java.util.List;
@Api(tags = "秋鹏的资讯信息接口")
@Controller
@Slf4j
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "咨讯信息查询+名称查询+分页")
    @PostMapping("/ybei/message/querypage")
    @ResponseBody
    public PageInfo<MessageBean> selsect(@RequestParam("me_name") String name, @RequestParam int currentPage, @RequestParam int pageSize){
        return messageService.select(name,currentPage,pageSize);
    }

    @ApiOperation(value = "咨询信息增加")
    @GetMapping("/ybei/message/insert")
    @ResponseBody
    public Boolean insert( MessageBean messageBean){
       return messageService.insertMess(messageBean);
    }

    @ApiOperation(value ="咨询信息编辑" )
    @PostMapping("/ybei/message/update")
    @ResponseBody
    public Boolean update(MessageBean messageBean){
        return  messageService.updateMess(messageBean);
    }


}
