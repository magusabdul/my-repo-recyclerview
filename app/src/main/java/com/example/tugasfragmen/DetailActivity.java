package com.example.tugasfragmen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgLogo;
    private TextView namaTim, detailTim;

    public static final String EXTRA_NO="extra_no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Resources resources = getResources();
        String[] teamName = resources.getStringArray(R.array.club_name);
        final TypedArray teamLogo = resources.obtainTypedArray(R.array.club_image);
        String[] teamDetail = resources.getStringArray(R.array.club_detail);

        String no = getIntent().getStringExtra(EXTRA_NO);
        imgLogo=findViewById(R.id.img_logo);
        namaTim =findViewById(R.id.text_team);
        detailTim = findViewById(R.id.text_detail);

        imgLogo.setImageResource(teamLogo.getResourceId(Integer.parseInt(no),-1));
        namaTim.setText(teamName[Integer.parseInt(no)]);
        detailTim.setText(teamDetail[Integer.parseInt(no)]);
    }
}