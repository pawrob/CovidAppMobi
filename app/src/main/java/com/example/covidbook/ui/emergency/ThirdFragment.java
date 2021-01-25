package com.example.covidbook.ui.emergency;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.covidbook.R;
import com.example.covidbook.info.PersonInfo;
import com.example.covidbook.info.PersonInfoList;

public class ThirdFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static ThirdFragment newInstance(int index) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);

//        submitButton = (Button) root.findViewById(R.id.submitButton);
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
//            @Override
//            public void onClick(View view) {
//                int radioID = radioGroup.getCheckedRadioButtonId();
//                radioButton=root.findViewById(radioID);
//                float totalTemp = (float) (np.getValue()+ np3.getValue()/10.0);
//
//
//                PersonInfo pI = new PersonInfo(totalTemp,rb.getRating(),np2.getValue(),radioButton.getText().toString(),eT.getText().toString());
//                personList.add(pI);
//                System.out.println(personList.toString());
//
//                PersonInfoList.saveData(getContext(),personList.getPersonInfoList());
//            }
//        });
    }

}