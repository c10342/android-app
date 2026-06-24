package com.example.myapp.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.myapp.R;
import com.example.myapp.fragment.CollectFragment;
import com.example.myapp.fragment.HomeFragment;
import com.example.myapp.fragment.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private final HomeFragment homeFragment = new HomeFragment();
    private final CollectFragment collectFragment = new CollectFragment();
    private final MyFragment myFragment = new MyFragment();
    private Fragment activeFragment = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        // 仅应用顶部状态栏 inset，底部由 BottomNavigationView 自行处理
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });

        initBottomNav();
    }

    private void initBottomNav() {
        // 预加载所有 Fragment，首次只显示首页
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, myFragment, "my").hide(myFragment)
                .add(R.id.fragment_container, collectFragment, "collect").hide(collectFragment)
                .add(R.id.fragment_container, homeFragment, "home")
                .commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                switchFragment(homeFragment);
                return true;
            } else if (id == R.id.nav_collect) {
                switchFragment(collectFragment);
                return true;
            } else if (id == R.id.nav_my) {
                switchFragment(myFragment);
                return true;
            }
            return false;
        });
    }

    private void switchFragment(Fragment target) {
        if (target == activeFragment) return;
        getSupportFragmentManager().beginTransaction()
                .hide(activeFragment)
                .show(target)
                .commit();
        activeFragment = target;
    }
}
