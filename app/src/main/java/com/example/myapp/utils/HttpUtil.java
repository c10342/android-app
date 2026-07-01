package com.example.myapp.utils;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtil {

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build();

    // 异步 GET
    public static void get(String url, Callback callback) {
        get(url,null,callback);
    }

    public static void get(String url, @Nullable Map<String, Object> params, Callback callback) {
        HttpUrl httpUrl = HttpUrl.parse(AppConfig.apiUrl+ url);
        if (httpUrl == null) {
            throw new IllegalArgumentException("Invalid url: " + url);
        }
        HttpUrl.Builder builder = httpUrl.newBuilder();
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    continue;
                }
                Object value = entry.getValue();
                if (value.getClass().isArray()) {
                    int len = Array.getLength(value);
                    for (int i = 0; i < len; i++) {
                        Object item = Array.get(value, i);
                        if (item != null) {
                            builder.addQueryParameter(entry.getKey(), String.valueOf(item));
                        }
                    }
                } else {
                    builder.addQueryParameter(entry.getKey(), String.valueOf(value));
                }
            }
        }
        Request request = new Request.Builder().url(builder.build()).build();
        client.newCall(request).enqueue(callback);
    }

    // 异步 POST JSON
    public static void post(String url,  Callback callback) {
        post(url,null,callback);
    }

    public static void post(String url, @Nullable Map<String, Object> params, Callback callback) {
        url = AppConfig.apiUrl+url;
        if (HttpUrl.parse(url) == null) {
            throw new IllegalArgumentException("Invalid url: " + url);
        }
        String json = new Gson().toJson(params != null ? params : new java.util.HashMap<String, Object>());
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder().url(url).post(body).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("onFailure", e.getMessage());
                callback.onFailure(call,e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                callback.onResponse(call,response);
            }
        });
    }
}
