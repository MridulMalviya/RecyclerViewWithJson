package com.malviya.recyclerviewwithjson.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.malviya.recyclerviewwithjson.R;
import com.malviya.recyclerviewwithjson.fragment.RecyclerListFragment;

/**
 * Created by Prafulla on 11/7/2016.
 */

public class MainActivty extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        fragmentAdd();
    }
    private void fragmentAdd() {
        FragmentManager fM = getSupportFragmentManager();
        FragmentTransaction fT=fM.beginTransaction();
        Fragment frag =new RecyclerListFragment();
        fT.add(R.id.fragment_container,frag);
        fT.commit();
    }
}
