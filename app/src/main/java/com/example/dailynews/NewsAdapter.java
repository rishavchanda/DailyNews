package com.example.dailynews;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    ArrayList<NewsHolder> newsHolders;
    Context context;
    public NewsAdapter(Context context,ArrayList<NewsHolder> newsHolders){
        this.newsHolders=newsHolders;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newscard,null);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final  NewsHolder model = newsHolders.get(position);

        holder.newsHeadline.setText(model.getNewsHeadline());
        holder.newsbrief.setText(model.getNewsLines());
        Glide.with(context)
                .load(model.getNewsImage())
                .into(holder.newsImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "categoryClicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsHolders.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView newsImage;
        TextView newsHeadline,newsbrief;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImage= itemView.findViewById(R.id.newImage);
            newsHeadline = itemView.findViewById(R.id.headline);
            newsbrief=itemView.findViewById(R.id.briefnews);
        }
    }
}
