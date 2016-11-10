package com.malviya.recyclerviewwithjson.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.malviya.recyclerviewwithjson.R;
import com.malviya.recyclerviewwithjson.adapter.PostAdapter;
import com.malviya.recyclerviewwithjson.application.AppController;
import com.malviya.recyclerviewwithjson.model.PostDataHolder;
import com.malviya.recyclerviewwithjson.utilities.DividerItemDecoration;
import com.malviya.recyclerviewwithjson.utilities.RecyclerItemClickListener;
import com.malviya.recyclerviewwithjson.utilities.SwipeHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Prafulla on 11/10/2016.
 */

public class RecyclerListFragment extends Fragment {
    private static final String TAG = "DB++";
    RecyclerView recyclerView;
    PostAdapter postAdapter;
    private ArrayList<PostDataHolder> postDataHolders;

    // json object response url
    String urlJsonObj = "https://jsonplaceholder.typicode.com/posts";
    String json_id = "id";
    String json_title = "title";
    String json_body = "body";
    Context context;

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postDataHolders = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_recyclerview_main, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        makeJsonArrayRequest();
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclicView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void makeJsonArrayRequest() {
        final JsonArrayRequest stringRequest = new JsonArrayRequest(urlJsonObj, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i(TAG, "" + response.toString());
                JSON_PARSE_DATA_AFTER_WEBCALL(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    private void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {
            PostDataHolder postDataHolder1 = new PostDataHolder();
            JSONObject json;
            try {
                json = response.getJSONObject(i);
                Log.i(TAG, "" + json.getString("id"));
                postDataHolder1.setId(json.getString(json_id));
                postDataHolder1.setTitle(json.getString(json_title));
                postDataHolder1.setBody(json.getString(json_body));
                postDataHolders.add(postDataHolder1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        postAdapter = new PostAdapter(postDataHolders, context);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Bundle bundle = new Bundle();
                        bundle.putString("ID", postDataHolders.get(position).getId());
                        bundle.putString("TITLE", postDataHolders.get(position).getTitle());
                        bundle.putString("BODY", postDataHolders.get(position).getBody());
                        //  Toast.makeText(context,""+ postDataHolders.get(position).getTitle(),Toast.LENGTH_SHORT).show();

                        //Add Fragment
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTrasaction = fragmentManager.beginTransaction();
                        Fragment fragment = new FragmentDetails();
                        fragment.setArguments(bundle);
                        fragmentTrasaction.replace(R.id.fragment_container, fragment);
                        fragmentTrasaction.addToBackStack("null");
                        fragmentTrasaction.commit();
                    }
                })
        );

        ItemTouchHelper.Callback callback = new SwipeHelper(postAdapter, context);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();
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
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
