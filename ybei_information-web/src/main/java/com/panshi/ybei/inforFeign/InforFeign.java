package com.panshi.ybei.inforFeign;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.bean.InforBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-infor-provide-lqp")
public interface InforFeign {
    @RequestMapping(value = "/ybei/infor/query",method = RequestMethod.POST)
    PageInfo<InforBean> selectInfor(@RequestParam String name, @RequestParam int currentPage, @RequestParam int pageSize);
}
