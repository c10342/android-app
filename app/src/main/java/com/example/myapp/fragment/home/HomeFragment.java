package com.example.myapp.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private HomePagerAdapter adapter;
    private final List<String> tabTitles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);

        adapter = new HomePagerAdapter(this);
        viewPager.setAdapter(adapter);

        // 将 TabLayout 与 ViewPager2 绑定
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabTitles.get(position))
        ).attach();

        // 默认示例数据，实际可由网络请求替换
        List<String> tabs = new ArrayList<>();
        tabs.add("推荐");
        tabs.add("关注");
        tabs.add("热门");
        tabs.add("影视");
        tabs.add("音乐");
        setTabs(tabs);
    }

    /**
     * 动态设置顶部 Tab 数据
     *
     * @param titles tab 标题列表
     */
    public void setTabs(@NonNull List<String> titles) {
        tabTitles.clear();
        tabTitles.addAll(titles);
        adapter.setTabs(titles);
    }
}
