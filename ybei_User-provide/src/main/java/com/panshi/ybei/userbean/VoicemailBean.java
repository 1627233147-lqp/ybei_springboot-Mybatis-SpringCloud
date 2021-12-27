package com.panshi.ybei.userbean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * 用户留言
 */
@ApiModel(description = "用户留言Bean")
@Data
public class VoicemailBean {
    private int leave_id;
    private String relation;
    private String relation_number;
    private String leave_sontent;
    private String feedback;
    private Date feedback_time;
    private int state;
    private Date esta_time;
    private Date update_time;
}
