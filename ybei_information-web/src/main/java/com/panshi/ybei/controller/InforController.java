package com.panshi.ybei.controller;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.bean.InforBean;
import com.panshi.ybei.inforFeign.InforFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.dc.pr.PRError;

@Controller
@Slf4j
public class InforController {
    @Autowired
    private InforFeign inforFeign;

    @RequestMapping("/web-Fegin/infor/query")
    @ResponseBody
    public PageInfo<InforBean> selectInfor(@RequestParam String name, @RequestParam int currentPage, @RequestParam int pageSize){
            return inforFeign.selectInfor(name, currentPage, pageSize);
    }
}
