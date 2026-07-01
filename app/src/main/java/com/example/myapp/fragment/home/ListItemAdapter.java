package com.example.myapp.fragment.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContent;
    private List<ListItemEntity> list;

    public ListItemAdapter(Context context, List<ListItemEntity> datas) {
        this.mContent = context;
        this.list = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContent).inflate(R.layout.home_list_item, parent, false);
        VideHolder videHolder = new VideHolder(view);
        return videHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideHolder vh = (VideHolder) holder;
        ListItemEntity item = list.get(position);
        vh.tvTitle.setText(item.getTitle());
        vh.tvName.setText(item.getName());
        vh.tvCommentCount.setText(String.valueOf(item.getCommentCount()));
        vh.tvDzCount.setText(String.valueOf(item.getLikeCount()));
        vh.tvCollectCount.setText(String.valueOf(item.getFavoriteCount()));
        Picasso.get()
                .load(item.getAvatar())
                .fit()
                .error(R.mipmap.ic_launcher)
                .transform(new CircleTransform())
                .into(vh.ivAvatar);
        Picasso.get()
                .load(item.getCover())
                .fit()
                .centerCrop()
                .into(vh.ivBanner);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class VideHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvName;

        private TextView tvCommentCount;


        private TextView tvDzCount;

        private TextView tvCollectCount;

        private ImageView ivAvatar;


        private ImageView ivBanner;

        public VideHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCommentCount = itemView.findViewById(R.id.tv_comment_count);
            tvDzCount = itemView.findViewById(R.id.tv_dz_count);
            tvCollectCount = itemView.findViewById(R.id.tv_collect_count);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            ivBanner = itemView.findViewById(R.id.iv_banner);
        }
    }
}
