package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView navigation;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        drawer = findViewById(R.id.drawer);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START);
        });
    }
}