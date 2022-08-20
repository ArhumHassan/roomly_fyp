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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {

    FirebaseDatabase db = FirebaseDatabase.getInstance("https://roomly-666-default-rtdb.firebaseio.com/");
    DatabaseReference ref = db.getReference("Users");
    EditText tname, tpassword, temail, tphone, tpin;
    Button signup;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Signup");
        tname = findViewById(R.id.name);
        tpassword = findViewById(R.id.password);
        temail = findViewById(R.id.email);
        tpin = findViewById(R.id.pin);
        signup = (Button) findViewById(R.id.signupbutton);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tname.getText().toString().isEmpty() || tpassword.getText().toString().isEmpty() || temail.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    Main2Activity.this.startActivity(intent);
                } else {
                    isUser();
                }
            }
        });
    }

    private void isUser() {

        final String enteredname = tname.getText().toString();

        final DatabaseReference ref = FirebaseDatabase.getInstance("https://roomly-666-default-rtdb.firebaseio.com/").getReference("Users");
        Query checkUser = ref.orderByChild("name").equalTo(enteredname);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    tname.setError(null);
                    tname.setError("Username taken! Try something else.");
                    tname.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    setContentView(R.layout.activity_main3);
                    String dbname = tname.getEditableText().toString();
                    String dbemail = temail.getEditableText().toString();
                    String dbpassword = tpassword.getEditableText().toString();
                    String dbphone = tphone.getEditableText().toString();
                    HelperClass hpc = new HelperClass(dbname, dbemail, dbpassword, dbphone);
                    ref.child(dbname).setValue(hpc);

                    Toast.makeText(getApplicationContext(), "Resigtered sucessfully", Toast.LENGTH_SHORT).show();
                    SessionManager sessionmanager = new SessionManager(Main2Activity.this);
                    sessionmanager.logoutUserFromSession();
                    Intent intent = new Intent(Main2Activity.this, MainMActivity.class);
                    Main2Activity.this.startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
//                   Main2Activity.this.startActivity(intent);


    }
}