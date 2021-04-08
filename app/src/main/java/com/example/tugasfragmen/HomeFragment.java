package com.example.tugasfragmen;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerViewTeam;
    private RecyclerAdapterTeam recyclerAdapterTeam;
    private ArrayList<Team> teamArrayList;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewTeam=view.findViewById(R.id.rcv_team);
        getTeam();
        recyclerAdapterTeam=new RecyclerAdapterTeam(getContext(), teamArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewTeam.setLayoutManager(layoutManager);
        recyclerViewTeam.setAdapter(recyclerAdapterTeam);

        recyclerAdapterTeam.setItemClickListener(new ItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                String no = teamArrayList.get(position).getNo();
                Toast.makeText(getActivity(), teamArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent pin;
                pin = new Intent(getActivity(),DetailActivity.class);
                pin.putExtra(DetailActivity.EXTRA_NO, no);
                startActivity(pin);
            }
        });
        return view;
    }

    private void getTeam(){
        if (teamArrayList==null){
            Resources resources = getResources();
            String[] teamName = resources.getStringArray(R.array.club_name);
            final TypedArray teamLogo = resources.obtainTypedArray(R.array.club_image);
            String[] teamDetail = resources.getStringArray(R.array.club_detail);
            String[] teamNo = resources.getStringArray(R.array.club_no);

            teamArrayList = new ArrayList<Team>();

            for (int i=0; i<teamName.length; i++){
                teamArrayList.add(new Team(teamName[i], String.valueOf(teamLogo.getResourceId(i, -1)), teamDetail[i], teamNo[i]));
            }
        }
    }
}