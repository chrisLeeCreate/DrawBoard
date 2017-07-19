package com.boxfish.stu.drawboard.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lishaowei on 2017/7/19.
 */

public class UserInvocation implements InvocationHandler {
    private Object target;

    public UserInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("getName")) {
            String string = (String) method.invoke(target, args);
            return string + "嘿嘿哈";
        }else {
            int invoke = (int) method.invoke(target, args);
            return invoke + 10;

        }
    }
}
