package com.example.covidbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.covidbook.info.PersonInfoAdapter;
import com.example.covidbook.info.PersonInfoList;

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


        final Button graphBtn = findViewById(R.id.button);
        graphBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerActivity.this, GraphActivity.class));
            }
        });
        }

}