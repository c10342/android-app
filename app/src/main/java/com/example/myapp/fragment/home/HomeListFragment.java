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
        String title = "";
        Bundle args = getArguments();
        if (args != null) {
            title = args.getString(ARG_TITLE, "");
        }

        FrameLayout root = new FrameLayout(requireContext());
        root.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        TextView textView = new TextView(requireContext());
        textView.setText(title);
        textView.setTextSize(20f);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        textView.setLayoutParams(params);
        root.addView(textView);

        return root;
    }
}
