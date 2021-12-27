package com.panshi.ybei.mapper;

import com.panshi.ybei.bean.MessageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 咨询信息Mapper
 */
@Mapper
public interface IMessageMapper {
    /**
     * 查询对象接口
     * @param name
     * @return
     */
    MessageBean query(String name);

    /**
     * 后台根据名称查询+分页
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<MessageBean> select(String name,int currentPage,int pageSize);

    /**
     * 咨询信息新增
     * @return
     */
    int insertMess(MessageBean messageBean);

    /**
     * 咨询信息编辑
     * @param messageBean
     * @return
     */
    int updateMess(MessageBean messageBean);

}
