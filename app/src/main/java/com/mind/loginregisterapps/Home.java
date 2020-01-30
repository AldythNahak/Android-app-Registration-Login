package com.mind.loginregisterapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity{

    private TextView tvLogin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvLogin2 = findViewById(R.id.tvLogin2);
         String fn= getIntent().getStringExtra(MainActivity.public_User_FullName);
         tvLogin2.setText(fn);
    }
}

