package com.panshi.ybei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panshi.ybei.bean.InforBean;
import com.panshi.ybei.mapper.IforTypeMapper;
import com.panshi.ybei.service.InforTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * @author 爱吃湘菜不爱吃香菜
 * @version :1.0
 * @Date :2021-7-8
 */
@Service
@Slf4j
public class InforTypeServiceImpl implements InforTypeService {
    @Autowired
    private IforTypeMapper iforTypeMapper;

    /**
     * 咨讯分类查询+名称查询+分页
     * @return
     */
    @Override
    public PageInfo<InforBean> selectInfor(String name,int currentPage,int pageSize) {
        log.info("currentPage={}，pageSize={}",currentPage,pageSize);
        PageHelper.startPage(currentPage, pageSize,true);
        List<InforBean> list =iforTypeMapper.selectInfor(name,currentPage,pageSize);
        PageInfo<InforBean> pageInfo=new PageInfo<>(list);
        return pageInfo;

    }
    /**
     * 咨询分类增加
     */
    @Override
    public Boolean insertInfor(InforBean inforBean) {
         InforBean inforBean1 = iforTypeMapper.query(inforBean.getType_name());
        if (inforBean1==null){
            return false;
        }
        iforTypeMapper.insertInfor(inforBean);
        return true;
    }

    /**
     * 咨询分类编辑
     * @param
     * @return
     */
    @Override
    public Boolean updateInfor(int id,String name,int sort, int state ) {
        InforBean i =iforTypeMapper.query(name);
        System.out.println("==========================="+i);
        if (i==null){
            return false;
        }
        System.out.println("sjkdjskjdksdjksd"+id+name+sort+state);
        iforTypeMapper.updateInfor(id,name, sort, state);
        return true;
    }

    @Override
    public InforBean query(String name) {
        return iforTypeMapper.query(name);
    }

    @Override
    public List<InforBean> inforselect() {
        return iforTypeMapper.inforselect();
    }

}
