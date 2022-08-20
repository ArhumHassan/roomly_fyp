package com.example.asp.roomly_one;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

public class LogoutActivity extends AppCompatActivity {
    Button Logout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SessionManager sessionmanager = new SessionManager(LogoutActivity.this);
        sessionmanager.logoutUserFromSession();
        setContentView(R.layout.activity_main);
//        finish();
//        Logout = (Button)findViewById(R.id.logout);
//        Logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openMainActivity();
    //}
   //     });
    }
    //public void openMainActivity(){
    //    Intent intent = new Intent(this, MainActivity.class);
    //    startActivity(intent);
   // }
}
