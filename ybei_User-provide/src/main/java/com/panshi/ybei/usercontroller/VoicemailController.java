package com.panshi.ybei.usercontroller;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.userbean.VoicemailBean;
import com.panshi.ybei.userservice.VoicemailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "秋鹏的用户留言接口")
@Controller
@Slf4j
public class VoicemailController {
    @Autowired
    private VoicemailService voicemailService;

    @ApiOperation(value = "用户留言查询接口")
    @PostMapping("/yebi/user/voicemail")
    @ResponseBody
    public PageInfo<VoicemailBean> query(@RequestParam("relation") String relation, @RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize){
        return voicemailService.query(relation, currentPage, pageSize);
    }

    @ApiOperation(value = "用户留言编辑接口")
    @PostMapping("/yebi/user/voicemailUpdate")
    @ResponseBody
    public Boolean update(@RequestParam int id,@RequestParam String feedback,@RequestParam String state){
        return voicemailService.update(id,feedback, state);
    }
    @RequestMapping("/ybei_vo/queryVo")
    @ResponseBody
    public VoicemailBean queryVo(@RequestParam int id){
        return voicemailService.queryVo(id);
    }

}
