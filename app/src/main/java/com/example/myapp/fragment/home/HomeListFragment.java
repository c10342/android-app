package com.example.myapp.fragment.home;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页 Tab 切换后的子页面占位，展示当前 Tab 的标题。
 * 实际项目中可在此加载对应的列表/视频流等。
 */
public class HomeListFragment extends Fragment {

    private static final String ARG_TITLE = "arg_title";

    public static HomeListFragment newInstance(@NonNull String title) {
        HomeListFragment fragment = new HomeListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_list, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        // 添加默认分割线（仅 LinearLayoutManager 支持）
        DividerItemDecoration decoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        List<ListItemEntity> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ListItemEntity item = new ListItemEntity();
            item.setTitle("韭菜盒子新做法，不发面不汤面");
            item.setName("大胃王");
            item.setDzCount(i * 2);
            item.setCommentCount(i * 3);
            item.setCollectCount(i * 4);
            list.add(item);
        }
        ListItemAdapter listItemAdapter = new ListItemAdapter(getActivity(), list);
        recyclerView.setAdapter(listItemAdapter);
        return v;
    }
}
