package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TemplatesActivity extends AppCompatActivity {

    ListView lv;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.category);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.category:
                        return true;

                    case R.id.work:
                        startActivity(new Intent(getApplicationContext(), CreatureActivity.class));
                        overridePendingTransition(0, 0);

                    case R.id.profile:
                        Toast.makeText(getApplicationContext(), "Переход на активность Профиль", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });



        TemplateListAdapter adapter = new TemplateListAdapter(this, makeTemplate());
        lv = (ListView) findViewById(R.id.templatesListView);
        lv.setAdapter(adapter);
    }

    // Метод cоздания массива месяцев
    MyTemplates[] makeTemplate() {
        MyTemplates[] arr = new MyTemplates[6];

        String[] titlesArr = {"Шаблоны людей", "Шаблоны транспорта", "Шаблоны мебели", "Шаблоны фонов", "Шаблоны предметов", "Шаблоны животных"};

        int[] imageResources = {R.drawable.ic_standingman, R.drawable.ic_car, R.drawable.ic_furniture, R.drawable.ic_background, R.drawable.ic_tools, R.drawable.ic_animal};


        for (int i = 0; i < arr.length; i++) {
            MyTemplates titles = new MyTemplates();
            titles.titleTemplate = titlesArr[i];
            titles.drawableID = imageResources[i];
            arr[i] = titles;
        }
        return arr;
    }
}