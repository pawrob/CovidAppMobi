package com.example.covidbook.ui.authors;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import com.example.covidbook.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutAuthorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_authors);


        Button btn = (Button) findViewById(R.id.info_button_1);
        Button btn2 = (Button) findViewById(R.id.info_button_2);
        Button btn3 = (Button) findViewById(R.id.info_button_3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/r00bertos1");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/pawrob");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:covidbook@bugs.com?subject=I Found a bug!")); // only email apps should handle this
                startActivity(intent);
            }
        });
    }

}