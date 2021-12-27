package com.panshi.ybei.controller;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.bean.InforBean;
import com.panshi.ybei.service.InforTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "秋鹏的资讯接口")
@Controller
@Slf4j
public class InforController {
    @Autowired
    private InforTypeService inforTypeService;
    /**
     * 咨讯分类查询+名称查询+分页
     * @param name 分类名称
     * @param currentPage 第几页比如第一页1
     * @param pageSize 分页需要查询的数量，比如10
     * @return list
     */
    @ApiOperation(value = "咨讯分类查询+名称查询+分页")
    @PostMapping("/ybei/infor/query")
    @ResponseBody
    public PageInfo<InforBean> selectInfor(@RequestParam String name, @RequestParam int currentPage, @RequestParam int pageSize){
      return inforTypeService.selectInfor(name, currentPage, pageSize);
    }

    /**
     * 咨询分类增加
     */    @ApiOperation(value = "添加咨询分类")
    @GetMapping("/ybei/infor/insert")
    @ResponseBody
    public Boolean insertInfor(InforBean inforBean){

            return inforTypeService.insertInfor(inforBean);
    }

    @ApiOperation(value = "咨讯分类编辑")
    @PostMapping("/ybei/infor/update")
    @ResponseBody
    public Boolean updateInfor(@RequestParam("id")int id,@RequestParam("typename") String name,@RequestParam int sort,@RequestParam int state ){
         return inforTypeService.updateInfor(id,name, sort, state);
    }
@RequestMapping(value = "/ybei/infor/queryname",method = RequestMethod.GET)
@ResponseBody
    public InforBean query(@RequestParam String name){
         return inforTypeService.query(name);
    }

@RequestMapping(value = "/ybei/infor/selecttype",method = RequestMethod.POST)
@ResponseBody
    public List<InforBean> inforSelect(){
         return  inforTypeService.inforselect();
    }
}
