package com.example.tugasfragmen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
{
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmenPage(new HomeFragment());

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        getFragmenPage(new HomeFragment());
                        setTitle(R.string.home_fragment);
                        break;
                    case R.id.menu_favorite:
                        getFragmenPage(new FavoriteFragment());
                        setTitle(R.string.favorite_fragment);
                        break;
                    case R.id.menu_about:
                        getFragmenPage(new AboutFragment());
                        setTitle(R.string.about_fragment);
                        break;
                }
                return true;
            }
        });

    }
    private boolean getFragmenPage(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
            return true;
        }
        return false;
    }
}