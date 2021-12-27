package com.panshi.ybei.userbean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 爱吃湘菜不爱吃香菜
 * @version :1.0
 * @Date :2021-7-6
 */
@ApiModel(description = "用户Bean")
@Data
public class UserBean implements Serializable {
    @ApiModelProperty(value = "用户id",required = true)
    private Integer ybei_id;
    @ApiModelProperty(value = "用户名")
    private String ybei_userName;
    @ApiModelProperty(value = "手机号")
    private  long u_cell_phone_number;
    @ApiModelProperty(value = "邮箱",required = true)
    private String u_mailbox;
    @ApiModelProperty(value = "头像")
    private  String u_head_portrait;
    @ApiModelProperty(value = "性别")
    private int  u_gender;
    @ApiModelProperty(value = "状态")
    private String u_state;
    @ApiModelProperty(value = "注册时间")
    private Date  u_login;
    @ApiModelProperty(value = "创建时间")
    private Date u_creation_time;
    @ApiModelProperty(value = "更新时间")
    private Date u_update_timr;
    @ApiModelProperty(value = "密码",required = true)
    private String u_password;

    @Override
    public String toString() {
        return "UserBean{" +
                "ybei_id=" + ybei_id +
                ", ybei_userName='" + ybei_userName + '\'' +
                ", u_cell_phone_number=" + u_cell_phone_number +
                ", u_mailbox='" + u_mailbox + '\'' +
                ", u_head_portrait='" + u_head_portrait + '\'' +
                ", u_gender='" + u_gender + '\'' +
                ", u_state=" + u_state +
                ", u_login=" + u_login +
                ", u_creation_time=" + u_creation_time +
                ", u_update_timr=" + u_update_timr +
                ", u_password='" + u_password + '\'' +
                '}';
    }
}
