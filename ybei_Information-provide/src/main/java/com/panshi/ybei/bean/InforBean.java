package com.panshi.ybei.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
/**
 * @author 爱吃湘菜不爱吃香菜
 * @version :1.0
 * @Date :2021-7-8
 */
@ApiModel(value = "资讯分类bean")
@Data
@NoArgsConstructor
public class InforBean{
    @ApiModelProperty(value = "资讯分类id")
    private int type_id;
    @ApiModelProperty(value = "资讯分类名称",required = true)
    private String type_name;
    @ApiModelProperty(value = "排序")
    private  int sort_id;
    @ApiModelProperty(value = "状态")
    private int state;
    @ApiModelProperty(value = "创建时间")
    private Date esta_time;
    @ApiModelProperty(value = "更新时间")
    private Date update_time;


}
