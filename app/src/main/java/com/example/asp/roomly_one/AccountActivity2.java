package com.example.asp.roomly_one;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class AccountActivity2 extends AppCompatActivity {

    TextView text;
    Button buttoned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
                            text = findViewById(R.id.datadata);

                            SessionManager sessionmanager = new SessionManager(this);
                            HashMap<String,String> userDetails = sessionmanager.getUsersDetailFromSession();
                            String username = userDetails.get(SessionManager.Key_name);
                            String email = userDetails.get(SessionManager.Key_email);
                            String phone = userDetails.get(SessionManager.Key_phone);

                            text.setText("Name: "+username+"\n\nEmail: "+email+"\n\nPhone: "+phone);

                            buttoned = (Button) findViewById(R.id.buttoned);
                            buttoned.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                }
                            });

                        }
    }
