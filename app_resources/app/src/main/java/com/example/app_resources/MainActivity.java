package com.example.app_resources;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jspecify.annotations.NonNull;

public class MainActivity extends AppCompatActivity {
    CheckBox cb;
    RadioGroup rdg;
    Spinner spinner;
    TimePicker tp;
    DatePicker dp;
    Button btn;
    ProgressBar pb;
    int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@androidx.annotation.NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(MainActivity.this, "HAAAAAAAA LOL FUCK YOU", Toast.LENGTH_SHORT).show();
                }
            }
        });
        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@androidx.annotation.NonNull RadioGroup group, int checkedId) {
                RadioButton rdb = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "You Selected: "+rdb.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "Hour: "+hourOfDay+" minute: "+minute, Toast.LENGTH_SHORT).show();
            }
        });
        dp = findViewById(R.id.dp);
        pb = findViewById(R.id.pb);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "DAY "+dp.getDayOfMonth();
                String month= "MONTH "+dp.getMonth();
                String year= "YEAR "+dp.getYear();
                Toast.makeText(MainActivity.this, day + "\n" + month + "\n" + year , Toast.LENGTH_LONG).show();
                progress = progress+10;
                pb.setProgress(progress);
            }
        });
        String[] courses = {"C++","Java","Kotlin","Python"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        spinner.setAdapter(adapter);
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int itemId = item.getItemId();
        if (itemId == R.id.home_icon)
        {
            Toast.makeText(this, "Home is selected", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.action_search)
        {
            Toast.makeText(this, "Search is selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}