package com.hph.useful;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 打印异常堆栈
 *
 * @author 陈飞飞    2016年11月1日 上午10:21:14
 */
public class MyException {
    /**
     * 异常堆栈转化为String
     *
     * @param t 异常对象
     * @return 异常堆栈信息
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            t.printStackTrace(pw);
            return sw.toString();
        }
    }
}
