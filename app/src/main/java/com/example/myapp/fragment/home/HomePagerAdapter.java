package com.example.myapp.fragment.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页顶部 Tab 对应的 ViewPager2 适配器，支持动态设置 Tab 数据。
 */
public class HomePagerAdapter extends FragmentStateAdapter {

    private final List<String> tabs = new ArrayList<>();

    public HomePagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public void setTabs(@NonNull List<String> titles) {
        tabs.clear();
        tabs.addAll(titles);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // 当 Tab 数据变化导致页数变化时需要调用
        return HomeListFragment.newInstance(tabs.get(position));
    }

    @Override
    public int getItemCount() {
        return tabs.size();
    }

    @Override
    public long getItemId(int position) {
        // 用 tab 标题的 hashCode 作为稳定 id，确保动态更新时正确刷新
        return tabs.get(position).hashCode();
    }

    @Override
    public boolean containsItem(long itemId) {
        for (String title : tabs) {
            if (title.hashCode() == itemId) return true;
        }
        return false;
    }
}
