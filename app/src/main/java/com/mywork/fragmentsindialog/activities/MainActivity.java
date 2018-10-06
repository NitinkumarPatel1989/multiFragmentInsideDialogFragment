package com.mywork.fragmentsindialog.activities;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.mywork.fragmentsindialog.R;
import com.mywork.fragmentsindialog.fragments.FirstFragment;
import com.mywork.fragmentsindialog.fragments.MainActivityFragment;
import com.mywork.fragmentsindialog.fragments.MainDialogFragment;
import com.mywork.fragmentsindialog.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.OnFragmentInteractionListener,MainDialogFragment.OnFragmentInteractionListener,
        FirstFragment.OnFragmentInteractionListener, SecondFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityFragment mainActivityFragment = MainActivityFragment.newInstance("param1", "param2");
        FragmentManager fm = getSupportFragmentManager();
        FrameLayout fl = findViewById(R.id.frag_main);
        fl.removeAllViews();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frag_main, mainActivityFragment, "MAIN_ACTIVITY_FRAGMENT");
        fragmentTransaction.commit();
        fm.executePendingTransactions();
    }

    @Override
    public void onDialogFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFirstFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSecondFragmentInteraction(Uri uri) {

    }
}
