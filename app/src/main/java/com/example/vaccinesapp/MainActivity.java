package com.example.vaccinesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    //1. AdapterView and RecyclerView
    RecyclerView recyclerView;

    //2.Data Source :
    VaccineModel[] myListData;

    //3. Adapter
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        myListData =new VaccineModel[]{
                new VaccineModel("Corona",R.drawable.corona),
                new VaccineModel("Cold",R.drawable.cold),
                new VaccineModel("swinflu",R.drawable.swineflu),
                new VaccineModel("Suger ",R.drawable.suger),
                new VaccineModel("Dengue",R.drawable.dengue),
                new VaccineModel("Polio",R.drawable.polio),
                new VaccineModel("Malaria",R.drawable.malaria)
        };

        //Adapter
        adapter=new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //Handling the click event

    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Vaccine Name "+myListData[pos].getTitle(), Toast.LENGTH_SHORT).show();
    }
}