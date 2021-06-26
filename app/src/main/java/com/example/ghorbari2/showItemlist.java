package com.example.ghorbari2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class showItemlist extends AppCompatActivity {


    private ListView listView;
    DatabaseReference databaseReference;

    private List<Item> itemlist;
    // private List<student> parentlist;
    private Arrayadapter customadapter;
    //private arrayadapter customadapter1;
    private ProgressBar progressbarShowItemId1;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_itemlist);


        /*********catching the district name***********/
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("stuff").trim();
        //show that it is a renter
        Bundle bundle1 = getIntent().getExtras();
        String renter1 = bundle1.getString("renter");

        progressbarShowItemId1=findViewById(R.id.progressbarShowItem);
        progressbarShowItemId1.setVisibility(View.VISIBLE);

       /* Bundle bundle2 = getIntent().getExtras();
        String owner2 = bundle2.getString("ownershow");*/
       // Toast.makeText(getApplicationContext(),renter1,Toast.LENGTH_SHORT).show();

        /*********End of catching*************/


        /*Toast.makeText(getApplicationContext()," asi",Toast.LENGTH_SHORT).show();
        if(renter1 != null){

            //Toast.makeText(getApplicationContext(),owner2,Toast.LENGTH_SHORT).show();
            databaseReference = FirebaseDatabase.getInstance().getReference(stuff);

        }
        //Toast.makeText(getApplicationContext(),owner2,Toast.LENGTH_SHORT).show();
        if(renter1 == null) {
            Intent intent = getIntent();
            String ownerNameget = intent.getStringExtra(ShowAllOwnerRoom.ownerName);
            Toast.makeText(getApplicationContext(),ownerNameget,Toast.LENGTH_SHORT).show();

            //databaseReference = FirebaseDatabase.getInstance().getReference("Owner").child(owner2);
        }*/



        databaseReference = FirebaseDatabase.getInstance().getReference(stuff);
        //  databaseReference = FirebaseDatabase.getInstance().getReference("Parents");
        listView = findViewById(R.id.listviewid);
        itemlist = new ArrayList<>();
        //parentlist = new ArrayList<>();
        customadapter = new Arrayadapter(showItemlist.this,itemlist);
        //customadapter1 = new arrayadapter(details.this,parentlist);

    }



    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                itemlist.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){   //for taking the value of database

                     Item item = dataSnapshot1.getValue(Item.class);
                    itemlist.add(item);
                    //parentlist.add(Student);
                }
                listView.setAdapter(customadapter);
                //listView.setAdapter(customadapter1);

                progressbarShowItemId1.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}
