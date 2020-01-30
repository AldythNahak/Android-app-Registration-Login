package com.mind.loginregisterapps;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btRegister;
    private TextView tvLogin;

    private EditText L_Username,L_Password;
    public static String public_User_FullName = "fullname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btRegister  = findViewById(R.id.btRegister);
        tvLogin     = findViewById(R.id.tvLogin);
        btRegister.setOnClickListener(this);
        L_Username = findViewById(R.id.L_Username);
        L_Password = findViewById(R.id.L_Password);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v==btRegister){
            Intent intent   = new Intent(MainActivity.this,RegisterActivity.class);
            Pair[] pairs    = new Pair[1];
            pairs[0] = new Pair<View,String>(tvLogin,"tvLogin");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public void Login (View l){
        String l_username = L_Username.getText().toString();
        String l_password = L_Password.getText().toString();

        Intent intent = getIntent();
        String reg_username=intent.getStringExtra(RegisterActivity.public_Username);
        String reg_password=intent.getStringExtra(RegisterActivity.public_Password);
        String reg_fullname=intent.getStringExtra(RegisterActivity.public_FullName);


        if (l_username.isEmpty()){
            Toast.makeText(this, "Username must not be empty", Toast.LENGTH_LONG).show();
            L_Username.setError("Please enter Username");
        }
        if (l_password.isEmpty()){
            Toast.makeText(this, "Password must not be empty", Toast.LENGTH_LONG).show();
            L_Password.setError("Please enter Password");
        }
        if (!l_username.equals(reg_username)){
            Toast.makeText(this, "Username not found", Toast.LENGTH_LONG).show();
            L_Username.setError("Username not found");
        }
        if (!l_password.equals(reg_password)){
            Toast.makeText(this, "Wrong Password", Toast.LENGTH_LONG).show();
            L_Password.setError("Wrong Password");
        }
        if (l_username.equals(reg_username)){
            if (l_password.equals(reg_password)) {
                Intent intent2 = new Intent(this, Home.class);
                intent2.putExtra(public_User_FullName, reg_fullname);
                startActivity(intent2);
            }
        }

    }
}
