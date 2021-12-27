package com.panshi.ybei.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一响应VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean<T> {
    /**
     * 状态码
     */
    String code;
    /**
     * 状态信息
     */
    String msg;
    /**
     * 返回数据对象
     */
    T data;
    /**
     * 定义一个静态方法，返回成功状态码
     * @return 响应对象
     */
    public static ResponseBean success(){
        return success(null);
    }
    /**
     * 定义一个静态方法，返回成功
     * @param data 设置成功返回参数
     * @return
     */
    public static <T> ResponseBean<T> success(T data){
        return new ResponseBean("200","操作成功",data);
    }
    /**
     * 定义一个静态方法，返回失败状态码，以及指定失败信息
     * @param msg 失败信息
     * @return 响应对象
     */
    public static ResponseBean fail(String msg){
        return new ResponseBean("999",msg,null);
    }
}
