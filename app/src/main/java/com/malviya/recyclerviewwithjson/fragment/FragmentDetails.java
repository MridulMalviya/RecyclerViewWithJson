package com.malviya.recyclerviewwithjson.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.malviya.recyclerviewwithjson.R;
import com.malviya.recyclerviewwithjson.model.PostDataHolder;

import java.util.ArrayList;

/**
 * Created by Prafulla on 11/8/2016.
 */

public class FragmentDetails extends Fragment {
    private static final String TAG = "DB++";
    TextView id;
    TextView title;
    TextView body;
    private ArrayList<PostDataHolder> postDataHolders;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details, container, false);
        Bundle bundle = this.getArguments();
        init(view, bundle);
        return view;
    }

    private void init(View v, Bundle bundle) {
        String ID = bundle.getString("ID", "null");
        String TITLE = bundle.getString("TITLE", "null");
        String BODY = bundle.getString("BODY", "null");
        id = (TextView) v.findViewById(R.id.editText_ID);
        title = (TextView) v.findViewById(R.id.editText_Title);
        body = (TextView) v.findViewById(R.id.editText_Body);
        id.setText(ID);
        body.setText(BODY);
        title.setText(TITLE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
