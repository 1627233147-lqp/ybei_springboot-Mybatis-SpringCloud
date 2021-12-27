package com.panshi.ybei.service;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.bean.InforBean;

import java.util.List;

public interface InforTypeService {
    /**
     * 咨讯分类查询+名称查询+分页
     * @return
     */
    PageInfo<InforBean> selectInfor(String name, int currentPage, int pageSize);
    /**
     * 咨询分类增加
     */
    Boolean insertInfor(InforBean inforBean);

    /**
     * 咨询分类编辑
     * @param
     * @return
     */
    Boolean updateInfor(int id,String name,int sort, int state );

    InforBean query(String name);
    List<InforBean> inforselect();
}
