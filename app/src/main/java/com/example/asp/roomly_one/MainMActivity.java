package com.example.asp.roomly_one;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainMActivity extends AppCompatActivity {
    public EditText name, password;
    private Button button, button2;
    public static String namme;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        name = findViewById(R.id.lname);
        password = findViewById(R.id.lpassword);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
//        namme = name.getText().toString();
        button.setOnClickListener(handler);
        button2.setOnClickListener(handler);


    }

    View.OnClickListener handler = new View.OnClickListener() {
        public void onClick(View v) {
            if (v == button) {
                if (name.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainMActivity.this, MainMActivity.class);
                    MainMActivity.this.startActivity(intent);
                } else {
                    isUser();
                }
            }
//                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
//                MainActivity.this.startActivity(intent);
            else if (v == button2) {
                Intent intent = new Intent(MainMActivity.this, Main2Activity.class);
                MainMActivity.this.startActivity(intent);
            }
        }
    };

    private void isUser() {

        final String enteredname = name.getText().toString();
        final String enteredpass = password.getText().toString();
        Intent intent = new Intent(MainMActivity.this, MainMActivity.class);
        intent.putExtra("namme",enteredname);
        startActivity(intent);

        DatabaseReference ref = FirebaseDatabase.getInstance("https://roomly-666-default-rtdb.firebaseio.com/").getReference("Users");
        Query checkUser = ref.orderByChild("name").equalTo(enteredname);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    name.setError(null);
                    String passDB = dataSnapshot.child(enteredname).child("pasword").getValue(String.class);

                    if(passDB.equals(enteredpass)){
                        password.setError(null);
                        Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();

                        String _name = dataSnapshot.child(enteredname).child("name").getValue(String.class);
                        String _phone = dataSnapshot.child(enteredname).child("phone").getValue(String.class);
                        String _email = dataSnapshot.child(enteredname).child("email").getValue(String.class);
                        String _password = dataSnapshot.child(enteredname).child("pasword").getValue(String.class);

                        //Create Session
                        SessionManager sessionmanager = new SessionManager(MainMActivity.this);
                        sessionmanager.createLoginSession(_name,_email,_phone,_password);
//                        startActivity(new Intent(getApplicationContext(),AccountActivity2.class));

                        Intent intent = new Intent(MainMActivity.this, Main3Activity.class);
                        MainMActivity.this.startActivity(intent);
//                        getAllData();

/*

                        startActivity(_intent);
*/
                    }
                    else{
                        password.setError("Password Incorrect!");
                        password.requestFocus();
                    }
                }
                else{
                    name.setError("User doesn't exist");
                    name.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
