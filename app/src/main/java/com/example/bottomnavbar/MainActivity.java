package com.example.bottomnavbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    private SmoothBottomBar bottomnavbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replace(new HomeFragment());
        bottomnavbar = findViewById(R.id.bottomnavbar);

        bottomnavbar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                switch (i){
                    case 0:
                        replace(new HomeFragment());
                        break;
                    case 1:
                        replace(new SearchFragment());
                        break;
                    case 2:
                        replace(new ProfileFragment());
                        break;
                }
                return true;
            }
        });
    }

    private void replace(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainframe,fragment);
        transaction.commit();
    }
}