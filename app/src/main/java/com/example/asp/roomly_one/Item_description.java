package com.example.asp.roomly_one;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Item_description extends AppCompatActivity {


    ImageView image;
    Button plusbtn,minubtn,add_to_cart;
    TextView count_cart,count_quantity,name_of_item,price_of_item,desc_of_item;
    int count=1;
    static int count1=0;
    int Image;
    String name,price;

    //for firebase user login

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item_description);


        name_of_item=(TextView)findViewById(R.id.size_cart);
        price_of_item=(TextView)findViewById(R.id.price_cart);



        image=(ImageView)findViewById(R.id.image_cart);
        count_cart=(TextView)findViewById(R.id.count_tv_layout);
        count_quantity=(TextView)findViewById(R.id.textView);
        plusbtn=(Button)findViewById(R.id.plusbtn);
        minubtn=(Button)findViewById(R.id.minubtn);
        add_to_cart=(Button)findViewById(R.id.add_to_cart);


        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doincrement_add_to_cart();
            }
        });

        minubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dodecrement__add_to_cart();
            }
        });

        //LOGIN REQUIRED TO ADD ITEM TO CART

        add_to_cart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //TO CHECK WHETHER USER HAS LOGGED IN OR NOT
                mAuth = FirebaseAuth.getInstance();
                mAuthListner = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
                    {

                        if (firebaseAuth.getCurrentUser() == null)
                        {
                            Intent loginIntent = new Intent(Item_description.this, MainMActivity.class);
                            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(loginIntent);
                        }
                    }
                };


                mAuth.addAuthStateListener(mAuthListner);

                //         count1++;
                //             count_cart.setText(String.valueOf(count1));


                Intent intent1 =new Intent(Item_description.this,add_to_cart.class);
                intent1.putExtra("Image",Image);
                intent1.putExtra("Name",name);
                intent1.putExtra("Price",price);
                intent1.putExtra("qty",count);
                startActivity(intent1);

            }
        });

        Intent intent=getIntent();
        Image=intent.getExtras().getInt("Image");
        name=intent.getExtras().getString("Name");
        price=intent.getExtras().getString("Price");

        image.setImageResource(Image);
        name_of_item.setText(name);
        price_of_item.setText(price);


    }

    private void  doincrement_add_to_cart()
    {
        count++;
        count_quantity.setText(String.valueOf(count));
    }

    private void  dodecrement__add_to_cart()
    {
        count--;
        count_quantity.setText(String.valueOf(count));
    }

}

