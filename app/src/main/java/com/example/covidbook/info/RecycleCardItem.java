package com.example.covidbook.info;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import com.example.covidbook.R;


public class RecycleCardItem extends RecyclerView.Adapter<RecycleCardItem.ExampleViewHolder> {

    private List<PersonInfo> mExampleList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mTextView3 = itemView.findViewById(R.id.textView3);

        }
    }
    public RecycleCardItem(List<PersonInfo> personInfoArrayList) {
        mExampleList = personInfoArrayList;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RecycleCardItem.ExampleViewHolder holder, int position) {
        PersonInfo currentItem = mExampleList.get(position);

        holder.mTextView1.setText("Rating: "+ currentItem.getRating());
        holder.mTextView2.setText("Temperature: "+ currentItem.getTemperature());
        holder.mTextView3.setText(currentItem.getNotes());
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
