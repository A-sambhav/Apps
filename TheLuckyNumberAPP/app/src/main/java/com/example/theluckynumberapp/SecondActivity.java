package com.example.theluckynumberapp;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView txt_view2 , txt_view3;
    Button share_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        txt_view2 = findViewById(R.id.txt_view2);
        txt_view3 = findViewById(R.id.txt_view3);
        share_btn = findViewById(R.id.share_btn);
        // recieving the contents
        Intent i= getIntent();
        String userName = i.getStringExtra("name");
        int random_num  = randomNumberGenerator();
        txt_view3.setText(" "+random_num);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share_data(userName, random_num);
            }
        });
        // generation of random no.s

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public int randomNumberGenerator()
    {
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;

    }
    public void share_data(String username, int randomnumber)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL,"sambhava06@gmail.com");
        i.putExtra(Intent.EXTRA_CC, "24bme010@nith.ac.in");
        i.putExtra(Intent.EXTRA_SUBJECT, username + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, username + "'s lucky no. is: " + randomnumber);
        startActivity(Intent.createChooser(i, "Choose an Email client :"));
    }
}