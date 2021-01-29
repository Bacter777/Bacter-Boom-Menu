package com.bacter.boommenu.wallpaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bacter.boommenu.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ImageViewHolder>
{
    List<customItems>itemsList;
    Context context;
    WallpaperActivity wallpaperActivity;
    public RecyclerViewAdapter(WallpaperActivity wallpaperActivity,List<customItems>itemsList2,Context context)
    {
        this.itemsList = itemsList2;
        this.context = context;
        this.wallpaperActivity = wallpaperActivity;
    }
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new ImageViewHolder(LayoutInflater.from(this.context).inflate(R.layout.custom_layout,parent,false));
    }
    public void onBindViewHolder(ImageViewHolder holder, int position)
    {
        Glide.with(this.context).load(this.itemsList.get(position).getUrl()).into(holder.imageView);
    }

    public int getItemCount()
    {
        return this.itemsList.size();
    }
    public void setCropWallpapers(List<customItems>itemsList)
    {
        this.itemsList = itemsList;
        notifyDataSetChanged();
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imageView;
        public ImageViewHolder(@NonNull View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            this.imageView = itemView.findViewById(R.id.img);
        }
        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(RecyclerViewAdapter.this.context,ViewActivity.class);
            intent.putExtra("images",RecyclerViewAdapter.this.itemsList.get(getAdapterPosition()).getUrl());
            RecyclerViewAdapter.this.context.startActivity(intent);
        }
    }
}
