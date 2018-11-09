package com.example.kein_gold.menutest.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.kein_gold.menutest.R;
import com.example.kein_gold.menutest.model.ArticleListDetail;
import com.example.kein_gold.menutest.utils.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageAdapter extends BaseAdapter {

    @Nullable
    @BindView(R.id.text_id)
    TextView textView;

    @Nullable
    @BindView(R.id.image_id)
    ImageView imageView;


    private Context context;
    private List<ArticleListDetail> articleListDetail;

    public ImageAdapter(Context context, List<ArticleListDetail> articleListDetail) {
        this.context = context;
        this.articleListDetail = articleListDetail;
    }

    public int getCount() {
        return articleListDetail.size();
    }

    public ArticleListDetail getItem(int position) {
        return articleListDetail.get(position);
    }

    public long getItemId(int position) {
        return articleListDetail.get(position).getId();
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView = inflater.inflate(R.layout.grid_item_layout, null);
        ButterKnife.bind(this, gridView);
        setGridData(getItem(position));

        return gridView;
    }

    private void setGridData(ArticleListDetail item) {
        if (!NotNull.validation(item.getShortTitle())) {
            item.setShortTitle("");
        }

        textView.setText(item.getShortTitle());
        Glide.with(context)
                .load(item.getImageUrl())
                .apply(new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .placeholder(android.R.color.darker_gray))
                .into(imageView);
    }
}
