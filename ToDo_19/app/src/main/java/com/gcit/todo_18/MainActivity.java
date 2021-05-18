package com.gcit.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Sport>mSportsData;
    private SportAdaptor mAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycleview);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this,gridColumnCount));
        mSportsData = new ArrayList();

        mAdaptor = new SportAdaptor(this, mSportsData);
        mRecyclerView.setAdapter(mAdaptor);

        initializeData();
    }

    private void initializeData() {
        TypedArray sportsImageResource = getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsList = getResources().getStringArray(R.array.Sports_titles);
        String[] sportsInfo= getResources().getStringArray(R.array.Sports_info);


        mSportsData.clear();

        for(int i =0; i<sportsList.length;i++){
            mSportsData.add(new Sport(sportsList[i],sportsInfo[i],sportsImageResource.getResourceId(i, 0)));
        }
        mAdaptor.notifyDataSetChanged();
        sportsImageResource.recycle();
    }


}