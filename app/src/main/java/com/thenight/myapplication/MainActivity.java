package com.thenight.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.thenight.myapplication.fragment.BerandaFragment;
import com.thenight.myapplication.fragment.InfoFragment;
import com.thenight.myapplication.fragment.ProfileFragment;
import com.thenight.myapplication.fragment.TimelineFragment;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    ChipNavigationBar BottomNav;
    private long backPressedTime;
    private Fragment fragment = null;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        BottomNav = findViewById(R.id.bottomBar);
        if (savedInstanceState == null) {
            BottomNav.setItemSelected(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            BerandaFragment berandaFragment = new BerandaFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, berandaFragment)
                    .commit();
        }
        BottomNav.setOnItemSelectedListener(i -> {
            Fragment fragment = null;

            switch (i) {
                case R.id.item1:
                    fragment = new BerandaFragment();
                    break;

                case R.id.item2:
                    fragment = new TimelineFragment();
                    break;

                case R.id.item3:
                    fragment = new InfoFragment();
                    break;
                case R.id.item4:
                    fragment = new ProfileFragment();
                    break;

            }
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();

            } else {
                Log.e(TAG, "Error in creating fragment");
            }

        });
    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();


    }
}