package com.zeasn.smart.tv.utils;

import android.util.Log;

/**
 * Author: xiongjun
 * Date: 2019/1/22
 * Description:
 */

public class LogUtil {
    private static final String TAG = "ZeasnLauncher";
    private static final boolean DEBUG = true;
    static String className;
    static String methodName;
    static int lineNumber;

    private static String createLog(String log ) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("=====");
        buffer.append(methodName);
        buffer.append("(").append(className).append(":").append(lineNumber).append(")=====:");
        buffer.append(log);
        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements){
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message){
        if (!DEBUG)
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.e(TAG, createLog(message));
    }

    public static void i(String message){
        if (!DEBUG)
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.i(TAG, createLog(message));
    }

    public static void d(String message){
        if (!DEBUG)
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.d(TAG, createLog(message));
    }

    public static void v(String message){
        if (!DEBUG)
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.v(TAG, createLog(message));
    }

    public static void w(String message){
        if (!DEBUG)
            return;
        getMethodNames(new Throwable().getStackTrace());
        Log.w(TAG, createLog(message));
    }

}
