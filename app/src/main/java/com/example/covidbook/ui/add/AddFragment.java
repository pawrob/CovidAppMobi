package com.example.covidbook.ui.add;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidbook.App;
import com.example.covidbook.R;
import com.example.covidbook.info.PersonInfo;
import com.example.covidbook.info.PersonInfoList;

import java.util.ArrayList;

public class AddFragment extends Fragment {

    private AddViewModel addViewModel;
    private RatingBar rb;
    private Button submitButton;
    private RadioGroup radioGroup;
    protected RadioButton radioButton;
    private EditText eT;
    public PersonInfoList personList = new PersonInfoList();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        addViewModel =
                new ViewModelProvider(this).get(AddViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add, container, false);


        personList.setPersonInfoList(PersonInfoList.loadData(getContext(),personList.getPersonInfoList()));
        NumberPicker np = root.findViewById(R.id.tempPick);
        NumberPicker np3 = root.findViewById(R.id.tempPick2);
        NumberPicker np2 = root.findViewById(R.id.pplPick);
        np.setMinValue(35);
        np2.setMinValue(0);
        np3.setMinValue(0);
        np.setMaxValue(45);
        np2.setMaxValue(100);
        np3.setMaxValue(9);
        np.setValue(36);
        np3.setValue(6);
        radioGroup= root.findViewById(R.id.radio);
        rb = root.findViewById(R.id.rateBar);
        eT = root.findViewById(R.id.notes);


        submitButton = (Button) root.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton=root.findViewById(radioID);
                float totalTemp = (float) (np.getValue()+ np3.getValue()/10.0);


                PersonInfo pI = new PersonInfo(totalTemp,rb.getRating(),np2.getValue(),radioButton.getText().toString(),eT.getText().toString());
                personList.add(pI);
                System.out.println(personList.toString());

                PersonInfoList.saveData(getContext(),personList.getPersonInfoList());
                Intent startIntent = new Intent(getActivity(), com.example.covidbook.RecyclerActivity.class);
                startActivity(startIntent);
            }
        });

        addViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

}