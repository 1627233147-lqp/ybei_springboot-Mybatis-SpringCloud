package com.panshi.ybei.userservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panshi.ybei.userbean.UserBean;
import com.panshi.ybei.userbean.VoicemailBean;
import com.panshi.ybei.usermapper.IVoicemailMapper;
import com.panshi.ybei.userservice.VoicemailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VoicemailServiceImpl implements VoicemailService {
    @Autowired
    private IVoicemailMapper iVoicemailMapper;
    @Override
    public PageInfo<VoicemailBean> query(String relation,int currentPage,int pageSize) {
        log.info("currentPage={}，pageSize={}",currentPage,pageSize);
        PageHelper.startPage(currentPage, pageSize,true);
        List<VoicemailBean> list =iVoicemailMapper.query(relation,currentPage,pageSize);
        PageInfo<VoicemailBean> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Boolean update(int id,String feedback,String state) {
           iVoicemailMapper.update(id,feedback,state);
        return true;
    }

    @Override
    public VoicemailBean queryVo(int id) {
        return iVoicemailMapper.queryVo(id);
    }

}
