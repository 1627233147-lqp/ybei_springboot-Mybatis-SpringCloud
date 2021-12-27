package com.panshi.ybei.userservice;

import com.github.pagehelper.PageInfo;
import com.panshi.ybei.userbean.VoicemailBean;

import java.util.List;

public interface VoicemailService {
    PageInfo<VoicemailBean> query(String relation, int currentPage, int pageSize);
    Boolean update(int id,String feedback,String state);
    VoicemailBean queryVo(int id);
}
