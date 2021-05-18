package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreatureActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creature);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.work);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.category:
                        startActivity(new Intent(getApplicationContext(), TemplatesActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.work:
                        return true;

                    case R.id.profile:
                        Toast.makeText(getApplicationContext(), "Переход на активность Профиль", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed()
    {
    }
}