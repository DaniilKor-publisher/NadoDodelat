package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {
    EditText username;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.etName);
        enter = (Button) findViewById(R.id.enterButton);
        enter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enterButton:
                String name = username.getText().toString().trim();

                if (name.isEmpty()) {
                    username.setError("Введите имя");
                    return;
                }

                if (name.length() < 3) {
                    username.setError("Имя должно содержать более 3 символов");
                    return;
                }

                Intent i = new Intent(LoginActivity.this, CreatureActivity.class);
                i.putExtra("name", name);
                startActivity(i);
        }
    }
}