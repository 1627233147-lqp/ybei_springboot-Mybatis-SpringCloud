package com.panshi.ybei.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author 爱吃湘菜不爱吃香菜
 * @version :1.0
 * @Date :2021-7-8
 */
@ApiModel(value = "资讯信息bean")
@Data
public class MessageBean implements Serializable {
    @ApiModelProperty(value = "资讯分类id")
    private int y_id;
    private int y_serial_number;
    private String type_name;
    private String y_headline;
    private String keyword;
    private String article_type;
    private String content_type;
    private int state;
    private Date release_time;
    private int self_support;
    private int recommend;
    private int top;
    private int browse_number;
    private int comment_number;
    private int collect_number;
    private Date establish_time;
    private Date update_time;
    private String brief_introduction;
    private String content_particulars;
    private String picture;
    private int the_content_level;
    private String source_name;
    private String url;
    private String author;


}
