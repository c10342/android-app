package com.example.myapp.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {
    Context ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
    }

    public void showToast(String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
    }

    public void navigationTo(Class cls) {
        Intent intent = new Intent(ctx, cls);
        startActivity(intent);
    }

    public  void  saveStringToSp(String key,String val){
        SharedPreferences sp = getSharedPreferences("android-app",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,val);
        editor.commit();
    }
}
