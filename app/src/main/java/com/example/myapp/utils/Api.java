package com.example.myapp.utils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;

public class Api {
    public static void login(String username, String password, Callback callback){
        Map<String,Object> params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        HttpUtil.post("/auth/login",params,callback);
    }

    public static void getHomeList(int pageNumber,int pageSize, Callback callback){
        Map<String,Object> params = new HashMap<>();
        params.put("page",pageNumber);
        params.put("pageSize",pageSize);
        HttpUtil.get("/news/list",params,callback);
    }
}
