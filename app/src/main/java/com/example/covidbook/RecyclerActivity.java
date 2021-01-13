package com.example.covidbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.covidbook.App;
import com.example.covidbook.R;
import com.example.covidbook.info.PersonInfoAdapter;
import com.example.covidbook.info.PersonInfoList;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {


        private RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager mLayoutManager;
        public PersonInfoList personList = new PersonInfoList();

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycler);
            personList.setPersonInfoList(PersonInfoList.loadData(App.context,personList.getPersonInfoList()));

            mRecyclerView = findViewById(R.id.recyclerView);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new PersonInfoAdapter(personList.getPersonInfoList());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }

}