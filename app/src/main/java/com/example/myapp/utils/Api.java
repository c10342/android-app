package com.example.myapp.utils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;

public class Api {
    public static void login(String account, String pwd, Callback callback){
        Map<String,Object> params = new HashMap<>();
        params.put("mobile",account);
        params.put("password",pwd);
        HttpUtil.post("/app/login",params,callback);
    }
}
