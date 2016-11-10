package com.malviya.recyclerviewwithjson.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.malviya.recyclerviewwithjson.R;
import com.malviya.recyclerviewwithjson.model.PostDataHolder;

import java.util.ArrayList;

/**
 * Created by Prafulla on 11/7/2016.
 */

public class PostAdapter extends RecyclerView.Adapter<PostMyHolder> {
    private ArrayList<PostDataHolder> postMyHolders;

    public PostAdapter(ArrayList<PostDataHolder> postDataHolders, Context context) {
        postMyHolders = postDataHolders;
    }

    @Override
    public PostMyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_activity_row, parent, false);
        PostMyHolder holder = new PostMyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(PostMyHolder holder, final int position) {
        holder.mId.setText(postMyHolders.get(position).getId());
        holder.mTitle.setText(postMyHolders.get(position).getTitle());
        holder.mBody.setText(postMyHolders.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postMyHolders.size();
    }

    //Remove Row
    public void removeItem(int position) {
        postMyHolders.remove(position);
        this.notifyItemRemoved(position);
        this.notifyItemRangeChanged(position, postMyHolders.size());
    }

    //Resume Row
    public void resumeItem(int position) {
        postMyHolders.set(position, postMyHolders.get(position));
        // this.notifyDataSetChanged();
        this.notifyItemRangeChanged(position, postMyHolders.size());
    }
}
