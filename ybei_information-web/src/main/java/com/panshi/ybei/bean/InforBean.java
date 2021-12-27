package com.panshi.ybei.bean;

import lombok.Data;

import java.util.Date;

@Data
public class InforBean {

    private int type_id;

    private String type_name;

    private  int sort_id;

    private int state;

    private Date esta_time;

    private Date update_time;
}
