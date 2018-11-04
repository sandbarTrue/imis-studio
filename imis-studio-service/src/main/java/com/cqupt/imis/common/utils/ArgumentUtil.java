package com.cqupt.imis.common.utils;

import com.cqupt.imis.common.exceptions.BadArgumentException;

/**
 * Created by zhoujun on 2018/8/5.
 */
public class ArgumentUtil {
    public static void agrgumentValid(Object object){
        if(object==null){
            throw new BadArgumentException("参数为空");
        }
    }
}
