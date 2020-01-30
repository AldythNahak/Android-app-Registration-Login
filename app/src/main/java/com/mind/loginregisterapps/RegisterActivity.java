package com.mind.loginregisterapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private RelativeLayout rlayout;
    private Animation animation;

    private EditText Username,Password,FullName,ConfirmPassword;

    public static String public_Username = "Username";
    public static String public_Password = "Password";
    public static String public_FullName = "FullName";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.bgHeader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rlayout = findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this,R.anim.uptodowndiagonal);
        rlayout.setAnimation(animation);

        Username = findViewById(R.id.Username);
        FullName = findViewById(R.id.FullName);
        Password = findViewById(R.id.Password);
        ConfirmPassword = findViewById(R.id.ConfirmPassword);
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public void Register (View v){
        String username = Username.getText().toString();
        String fullname = FullName.getText().toString();
        String password = Password.getText().toString();
        String confirmpassword = ConfirmPassword.getText().toString();

        if (username.isEmpty()){
            Toast.makeText(this, "Username must not be empty", Toast.LENGTH_LONG).show();
            Username.setError("Username must not empty");
        }
        if (fullname.isEmpty()){
            Toast.makeText(this, "Full name must not be empty", Toast.LENGTH_LONG).show();
            FullName.setError("Full name must not empty");
        }
        if (password.isEmpty()){
            Toast.makeText(this, "Password must not be empty", Toast.LENGTH_LONG).show();
            Password.setError("Password must not empty");
        }
        if (confirmpassword.isEmpty()){
            Toast.makeText(this, "You must confirm the password first", Toast.LENGTH_LONG).show();
            ConfirmPassword.setError("You must confirm the password first");
        }
        if (!confirmpassword.equals(password)){
            Toast.makeText(this, "Password Not same", Toast.LENGTH_LONG).show();
            ConfirmPassword.setError("Password Not same");
        }
        if (!isEmpty(Username)){
            if (!isEmpty(FullName)) {
                if (!isEmpty(Password)) {
                    if (confirmpassword.equals(password)) {
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.putExtra(public_Username, username);
                        intent.putExtra(public_Password, password);
                        intent.putExtra(public_FullName, fullname);
                        startActivity(intent);
                    }
                }
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
