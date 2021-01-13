package com.example.covidbook.info;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidbook.R;


public class PersonInfoAdapter extends RecyclerView.Adapter<PersonInfoAdapter.ExampleViewHolder> {

    private List<PersonInfo> mExampleList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }
    public PersonInfoAdapter(List<PersonInfo> personInfoArrayList) {
        mExampleList = personInfoArrayList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

//    @Override
//    public void onBindViewHolder(@NonNull ExampleAdapter.ExampleViewHolder holder, int position) {
//
//    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(PersonInfoAdapter.ExampleViewHolder holder, int position) {
        PersonInfo currentItem = mExampleList.get(position);

        holder.mTextView1.setText("Rating: "+ currentItem.getRating());
        holder.mTextView2.setText("Temperature: "+ currentItem.getTemperature());
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
