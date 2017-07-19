package com.boxfish.stu.drawboard.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.boxfish.stu.drawboard.Proxy.User;
import com.boxfish.stu.drawboard.Proxy.UserInvocation;
import com.boxfish.stu.drawboard.Proxy.UserListener;
import com.boxfish.stu.drawboard.R;

import java.lang.reflect.Proxy;

public class Main3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        UserListener user = new User();

        UserInvocation userInvocation = new UserInvocation(user);
        UserListener u = (UserListener) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), userInvocation);
//
        Log.e("proxy", u.getName());
        Log.e("proxy", u.getAge() + "");
    }

}
