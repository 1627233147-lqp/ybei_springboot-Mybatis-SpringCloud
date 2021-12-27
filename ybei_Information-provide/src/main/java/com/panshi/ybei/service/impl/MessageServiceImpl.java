package com.panshi.ybei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panshi.ybei.bean.InforBean;
import com.panshi.ybei.bean.MessageBean;
import com.panshi.ybei.mapper.IMessageMapper;
import com.panshi.ybei.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
@Autowired
private IMessageMapper iMessageMapper;
    @Override
    public PageInfo<MessageBean> select(String name, int currentPage, int pageSize) {
        log.info("currentPage={}，pageSize={}",currentPage,pageSize);
        PageHelper.startPage(currentPage, pageSize,true);
        List<MessageBean> list =iMessageMapper.select(name,currentPage,pageSize);
        PageInfo<MessageBean> pageInfo=new PageInfo<>(list);
        return pageInfo;
     }

    /**
     * 增加
     * @param messageBean
     * @return
     */
    @Override
    public Boolean insertMess(MessageBean messageBean) {
        MessageBean messageBean1 = iMessageMapper.query(messageBean.getY_headline());
        if (messageBean1==null){
            return false;
        }
        iMessageMapper.insertMess(messageBean);
        return true;
    }

    @Override
    public Boolean updateMess(MessageBean messageBean) {
        MessageBean messageBean1 = iMessageMapper.query(messageBean.getY_headline());
        if (messageBean1==null
        ){
            return false;
        }
        iMessageMapper.updateMess(messageBean);
        return true;
    }
}
