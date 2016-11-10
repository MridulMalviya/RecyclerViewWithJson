package com.malviya.recyclerviewwithjson.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.malviya.recyclerviewwithjson.R;

/**
 * Created by Prafulla on 11/7/2016.
 */


public class PostMyHolder extends RecyclerView.ViewHolder {
    TextView mId;
    TextView mTitle;
    TextView mBody;

    public PostMyHolder(View itemView) {
        super(itemView);
        mId = (TextView) itemView.findViewById(R.id.textView_id);
        mTitle = (TextView) itemView.findViewById(R.id.textView_title);
        mBody = (TextView) itemView.findViewById(R.id.textViewBody);
    }

}
