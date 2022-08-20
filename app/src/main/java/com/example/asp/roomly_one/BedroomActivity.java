package com.example.asp.roomly_one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;


/*
public class BedroomActivity extends AppCompatActivity {
        ArrayList<String> imagelist;
        RecyclerView recyclerView;
        StorageReference root;
        ProgressBar progressBar;
        ImageAdapter adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.showbedroom);
                imagelist=new ArrayList<>();
                recyclerView=findViewById(R.id.recyclerviewbed);
                adapter=new ImageAdapter(imagelist,this);
                recyclerView.setLayoutManager(new LinearLayoutManager(null));
                progressBar=findViewById(R.id.progress);
                progressBar.setVisibility(View.VISIBLE);
                StorageReference listRef = FirebaseStorage.getInstance().getReference().child("bedroomitems");
//                FirebaseStorage storage = FirebaseStorage.getInstance();
//                StorageReference listRef = storage.getReference();
                listRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
                        @Override
                        public void onSuccess(ListResult listResult) {
                                for(StorageReference file:listResult.getItems()){
                                        file.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                @Override
                                                public void onSuccess(Uri uri) {
                                                        imagelist.add(uri.toString());
                                                        Log.e("Itemvalue",uri.toString());
                                                }
                                        }).addOnSuccessListener(new OnSuccessListener<Uri>() {
                                                @Override
                                                public void onSuccess(Uri uri) {
                                                        recyclerView.setAdapter(adapter);
                                                        progressBar.setVisibility(View.GONE);
                                                }
                                        });
                                }
                        }
                });
        }
}
*/


/*
public class BedroomActivity extends AppCompatActivity {

        // Initializing the ImageView
        ImageView rImage;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_bedroom);

                // getting ImageView by its id
                rImage = findViewById(R.id.rImage);

                // we will get the default FirebaseDatabase instance
//                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

                // we will get a DatabaseReference for the database root node
//                DatabaseReference databaseReference = firebaseDatabase.getReference();

                // Here "image" is the child node value we are getting
                // child node data in the getImage variable
//                DatabaseReference getImage = databaseReference.child("bed11");

                DatabaseReference getImage = FirebaseDatabase.getInstance().getReference("stores").child("bedroom");


                // Adding listener for a single change
                // in the data at this location.
                // this listener will triggered once
                // with the value of the data at the location
                getImage.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                // getting a DataSnapshot for the location at the specified
                                // relative path and getting in the link variable
                                String link = dataSnapshot.getValue(String.class);

                                // loading that data into rImage
                                // variable which is ImageView
                                Picasso.get().load(link).into(rImage);
                        }

                        // this will called when any problem
                        // occurs in getting data
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                                // we are showing that error message in toast
                                Toast.makeText(BedroomActivity.this, "Error Loading Image", Toast.LENGTH_SHORT).show();
                        }
                });
        }
}
*/


public class BedroomActivity extends AppCompatActivity {
    ImageView imageView;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom);

        imageView=findViewById(R.id.image);

        String url="https://firebasestorage.googleapis.com/v0/b/roomly-666.appspot.com/o/bedroomitems%2Fwoodenbed.png?alt=media&token=d2e37cda-d3e6-4f65-9b29-7397b924672d";//Retrieved url as mentioned above

        Glide.with(getApplicationContext()).load(url).into(imageView);

        }
        }

/*
public class BedroomActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Recyclerviewadapter myadapter;
    private FirebaseAuth firebaseAuth;
    //    private DatabaseReference reference = FirebaseDatabase.getInstance("https://roomly-666-default-rtdb.firebaseio.com/").getReference("Store").child("bedroom");
    List<item_images> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Bedroom Items");

        recyclerView=(RecyclerView)findViewById(R.id.recyclerv);
        recyclerView.setLayoutManager(new GridLayoutManager(BedroomActivity.this,2));
        list=new ArrayList<>();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("stores").child("bedroom");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    item_images itemImages = dataSnapshot1.getValue(item_images.class);
                    list.add(itemImages);
                }
                myadapter = new Recyclerviewadapter(BedroomActivity.this, list);
                recyclerView.setAdapter(myadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

*/
