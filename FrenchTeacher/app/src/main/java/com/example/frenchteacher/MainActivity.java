package com.example.frenchteacher;

import android.media.MediaPlayer;import android.os.Bundle;
import android.view.Menu;import android.view.View;import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button blackbtn;
    Button redbtn;
    Button greenbtn;
    Button purplebtn;
    Button yellowbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        blackbtn = findViewById(R.id.blackbtn);
        redbtn = findViewById(R.id.redbtn);
        greenbtn = findViewById(R.id.greenbtn);
        purplebtn = findViewById(R.id.purplebtn);
        yellowbtn = findViewById(R.id.yellowbtn);
        blackbtn.setOnClickListener(this);
        redbtn.setOnClickListener(this);
        greenbtn.setOnClickListener(this);
        purplebtn.setOnClickListener(this);
        yellowbtn.setOnClickListener(this);

        setSupportActionBar(findViewById(R.id.toolbar));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.blackbtn) {
            playSound(R.raw.black);
        } else if (id == R.id.redbtn) {
            playSound(R.raw.red);
        } else if (id == R.id.greenbtn) {
            playSound(R.raw.green);
        } else if (id == R.id.purplebtn) {
            playSound(R.raw.purple);
        } else if (id == R.id.yellowbtn) {
            playSound(R.raw.yellow);
        }
    }

    public void playSound(int sound) {
        MediaPlayer mp = MediaPlayer.create(this, sound);
        if (mp != null) {
            mp.setOnCompletionListener(MediaPlayer::release);
            mp.start();
        }
    }
}
