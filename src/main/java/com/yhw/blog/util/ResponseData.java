package com.yhw.blog.util;

import lombok.Data;

/**
 * @Author yhw
 */
@Data
public class ResponseData {
    private int code;
    private String msg;
    private Object object;
    private Integer userid;
    public ResponseData(int code,String msg,Integer userid,Object object){
        this.userid=userid;
        this.code=code;
        this.msg=msg;
        this.object=object;
    }

    public ResponseData(int code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
