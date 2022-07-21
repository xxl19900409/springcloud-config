package com.entity.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaxl
 * @version v1.0
 * @ClassName CommonResult
 * @Descrption TODO
 * @date 2022/7/12 16:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {

    private Integer code;

    private String message;

    private Object data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }


    public static CommonResult success(){
        return new CommonResult(200,"操作成功",null);
    }

    public static CommonResult success(Object t){
        return new CommonResult(200,"操作成功",t);
    }

    public static CommonResult error(){
        return new CommonResult(500,"操作失败",null);
    }
    public static CommonResult error(String message){
        return new CommonResult(500,message,null);
    }
    public static CommonResult success(Object t,String msg){
        return new CommonResult(200,msg,t);
    }
}
