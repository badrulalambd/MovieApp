package com.badrulacademy.movieappmvvm.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.badrulacademy.movieappmvvm.R;
import com.badrulacademy.movieappmvvm.service.model.Result;
import com.bumptech.glide.Glide;

import java.util.List;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.MyViewHolder>{

    private final Context mContext;
    private final List<Result> mList;

    public TopMovieListAdapter(Context mContext, List<Result> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_sample_layout, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTitle.setText(mList.get(position).getTitle());
        holder.mRating.setText(mList.get(position).getVoteCount().toString());
        holder.mTitle.setText(mList.get(position).getReleaseDate());
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500/"+mList.get(position).getPosterPath())
                .into(holder.mImageView);
        //https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg
    }

    @Override
    public int getItemCount() {
        if(this.mList != null){
            return mList.size();
        }else {
            return 0;
        }

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTitle, mRating, mRealiseDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.textView_title_id);
            mImageView = itemView.findViewById(R.id.imageView_id);
            mRating = itemView.findViewById(R.id.textView_rating_id);
            mRealiseDate = itemView.findViewById(R.id.textView_releaseDate_id);
        }
    }

}
