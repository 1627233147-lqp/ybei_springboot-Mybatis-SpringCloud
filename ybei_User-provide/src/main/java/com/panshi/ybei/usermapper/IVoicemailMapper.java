package com.panshi.ybei.usermapper;

import com.panshi.ybei.userbean.VoicemailBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IVoicemailMapper {
    /**
     * 用户留言 后台查询+分页
     * @param relation
     * @return
     */
    List<VoicemailBean> query(String relation,int currentPage,int pageSize);

    /**
     * 编辑
     * @param
     * @return
     */
    int update(int id,String feedback,String state);

    VoicemailBean queryVo(int id);
}
