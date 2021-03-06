package com.example.zmc_recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Data> mDataList;
    private Context mContext;

    public static class ItemHolder extends RecyclerView.ViewHolder {
        TextView dataTitle;
        TextView dataNumber;
        TextView dataDescription;

        public ItemHolder(View view) {
            super(view);
            dataTitle = view.findViewById(R.id.recycle_title);
            dataNumber = view.findViewById(R.id.recycle_number);
            dataDescription = view.findViewById(R.id.recycle_description);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitle;

        public HeaderViewHolder(View view) {
            super(view);
            headerTitle = view.findViewById(R.id.header_title);
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView dataTitle;
        TextView dataNumber;
        TextView dataDescription;
        ImageView dataAvatar;

        public ImageViewHolder(View view) {
            super(view);
            dataTitle = view.findViewById(R.id.image_recycle_title);
            dataNumber = view.findViewById(R.id.image_recycle_number);
            dataDescription = view.findViewById(R.id.image_recycle_description);
            dataAvatar = view.findViewById(R.id.image_recycle_image);
        }
    }

    public DataAdapter(List<Data> dataList) {
        mDataList = dataList;
    }

    public DataAdapter(Context context,List<Data> dataList) {
        mContext= context;
        mDataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == Data.TYPE_ITEM) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);
            return new ItemHolder(view);
        } else if (viewType == Data.TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, parent, false);
            return new HeaderViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
            return new ImageViewHolder(view);
        }
    }

    @Override

    public int getItemViewType(int position) {
        return mDataList.get(position).type;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data data = mDataList.get(position);
        if (data.type == Data.TYPE_HEADER) {
            ((HeaderViewHolder) holder).headerTitle.setText(data.title);
        } else if (data.type == Data.TYPE_ITEM) {
            ((ItemHolder) holder).dataTitle.setText(data.title);
            ((ItemHolder) holder).dataNumber.setText(String.valueOf(data.number));
            ((ItemHolder) holder).dataDescription.setText(data.description);
        } else if (2 == data.type) {
            Glide.with(mContext).load(data.avatar).into(((ImageViewHolder) holder).dataAvatar);;
            ((ImageViewHolder) holder).dataTitle.setText(data.title);
            ((ImageViewHolder) holder).dataNumber.setText(String.valueOf(data.number));
            ((ImageViewHolder) holder).dataDescription.setText(data.description);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
