package com.panshi.ybei.service;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.bean.MessageBean;

import java.util.List;

public interface MessageService {
    /**
     * 后台根据名称查询+分页
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<MessageBean> select(String name, int currentPage, int pageSize);

    /**
     * 咨询信息新增
     * @return
     */
    Boolean insertMess(MessageBean messageBean);

    /**
     * 咨询信息编辑
     * @param messageBean
     * @return
     */
    Boolean updateMess(MessageBean messageBean);
}
