package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JoinActivity extends AppCompatActivity {

    private TextView data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        data = findViewById(R.id.join_data);
        Intent intent = getIntent();

        String name = intent.getExtras().getString("name");
        String email = intent.getExtras().getString("email");
        String tel = intent.getExtras().getString("tel");
        String addr = intent.getExtras().getString("addr");
        String id = intent.getExtras().getString("id");
        String password = intent.getExtras().getString("password");

        String msg = String.format("name : %s \n email : %s \n tel : %s \n addr : %s \n id : %s \n password : %s",
                name,email,tel,addr,id,password);
        data.setText(msg);

    }
}