package com.example.myapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapp.R;
import com.example.myapp.entity.LoginRespond;
import com.example.myapp.utils.Api;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;

    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);

        etAccount.setText("admin");
        etPwd.setText("123456");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                login(account, pwd);
            }
        });
    }

    private void login(String account, String pwd) {
        if (account.isEmpty()) {
            showToast("请输入账号");
            return;
        }
        if (pwd.isEmpty()) {
            showToast("请输入密码");
            return;
        }

        Api.login(account, pwd, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(() -> {
                    showToast("请求失败:" + e.toString());
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String result = response.body().string();
                Log.e("MyLoginActivity", "onResponse: " + result);
                runOnUiThread(() -> {
                    Gson gson = new Gson();
                    LoginRespond res = gson.fromJson(result, LoginRespond.class);
                    if (res.getCode() == 200) {
                        String token = res.getData().getToken();
                        saveStringToSp("token", token);
                        showToast("登陆成功");
                        navigationTo(HomeActivity.class);
                    } else {
                        showToast("登陆失败");
                    }
                });


            }
        });
    }
}