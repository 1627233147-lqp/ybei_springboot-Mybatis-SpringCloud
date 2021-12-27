package com.panshi.ybei.mapper;

import com.panshi.ybei.bean.InforBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author 爱吃湘菜不爱吃香菜
 * @version :1.0
 * @Date :2021-7-8
 */
@Mapper
public interface IforTypeMapper {
    /**
     * 对象
     * @param name
     * @return
     */
    InforBean query(String name);
    /**
     * 咨讯分类查询+名称查询+分页
     * @return
     */
    List<InforBean> selectInfor(String name,int currentPage,int pageSize);

    /**
     * 咨询分类增加
     */
    int insertInfor(InforBean inforBean);

    /**
     * 咨询分类编辑
     * @return
     */
    int updateInfor(int ides,String names,int sort, int states );

   List<InforBean> inforselect();

}
