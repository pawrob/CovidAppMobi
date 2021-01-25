package com.example.covidbook.info.name;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.covidbook.App;
import com.example.covidbook.MainActivity;
import com.example.covidbook.R;


public class NameActivity extends AppCompatActivity {

    private EditText nameInput;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameInput = (EditText) findViewById(R.id.name);
        nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                confirm.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                SharedPreferences sharedPreferences = App.context.getSharedPreferences("shared preferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("inputName", nameInput.getText().toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                confirm.setEnabled(true);
            }
        });

        confirm = (Button) findViewById(R.id.submitButton);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameData = nameInput.getText().toString();
                System.out.println(nameData);
                Intent startIntent = new Intent(view.getContext(), MainActivity.class);
                startIntent.putExtra("NameIMP",  nameData);
                startActivity(startIntent);
            }
        });
    }
}