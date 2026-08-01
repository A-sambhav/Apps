package com.example.planetsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lst;
    ArrayList<Planet> planetsArrayList;
    private static MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // AdapterView = ListView
        lst = findViewById(R.id.lst);
        // Data Source : ArrayList
        planetsArrayList = new ArrayList<>();
        Planet p1 = new Planet("Mercury", "0", R.drawable.mercury);
        planetsArrayList.add(p1);
        Planet p2 = new Planet("Venus", "0", R.drawable.venus);
        planetsArrayList.add(p2);
        Planet p3 = new Planet("Earth", "1", R.drawable.earth);
        planetsArrayList.add(p3);
        Planet p4 = new Planet("Mars", "2", R.drawable.mars);
        planetsArrayList.add(p4);
        Planet p5 = new Planet("Jupiter", "79", R.drawable.jupiter);
        planetsArrayList.add(p5);
        Planet p6 = new Planet("Saturn", "82", R.drawable.saturn);
        planetsArrayList.add(p6);
        Planet p7 = new Planet("Uranus", "27", R.drawable.uranus);
        planetsArrayList.add(p7);
        Planet p8 = new Planet("Neptune", "14", R.drawable.neptune);
        planetsArrayList.add(p8);
        Planet p9 = new Planet("Pluto", "5", R.drawable.pluto);
        planetsArrayList.add(p9);
        // Adapter
        MyCustomAdapter adapter = new MyCustomAdapter(this, planetsArrayList);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Planet Name: " + planetsArrayList.get(position).getPlanetname() + "\nMoons: " + planetsArrayList.get(position).getMooncount() + "", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}