package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextView input_id = null;
    private TextView input_password = null;
    private TextView input_name = null;
    private TextView input_email = null;
    private TextView input_tel = null;
    private TextView input_addr = null;
    private Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_id = findViewById(R.id.user_id);
        input_password = findViewById(R.id.password);
        input_name = findViewById(R.id.name);
        input_addr = findViewById(R.id.addr);
        input_tel = findViewById(R.id.tel);
        input_email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        button.setOnClickListener((view)->{
            String email = input_email.getText().toString();
            String name = input_name.getText().toString();
            String addr = input_addr.getText().toString();
            String tel = input_tel.getText().toString();
            String id = input_id.getText().toString();
            String password = input_password.getText().toString();

            if(name.isEmpty()){
                input_name.setError("반드시입력하시오");
                input_name.setFocusable(true);
                return;
            }else if(email.isEmpty()){
                input_email.setError("반드시입력하시오");
                input_email.setFocusable(true);
                return;
            }else if(addr.isEmpty()){
                input_addr.setError("반드시입력하시오");
                input_addr.setFocusable(true);
                return;
            }else if(tel.isEmpty()){
                input_tel.setError("반드시입력하시오");
                input_tel.setFocusable(true);
                return;
            }else if(id.isEmpty()){
                input_id.setError("반드시입력하시오");
                input_id.setFocusable(true);
                return;
            }else if(password.isEmpty()) {
                input_password.setError("반드시입력하시오");
                input_password.setFocusable(true);
                return;
            }

            Intent join_intent = new Intent(MainActivity.this,JoinActivity.class);
            join_intent.putExtra("name", name);
            join_intent.putExtra("email", email);
            join_intent.putExtra("addr", addr);
            join_intent.putExtra("tel", tel);
            join_intent.putExtra("id", id);
            join_intent.putExtra("password", password);
            startActivity(join_intent);
        });
    }

}