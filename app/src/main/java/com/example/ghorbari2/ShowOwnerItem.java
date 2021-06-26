package com.example.ghorbari2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowOwnerItem extends AppCompatActivity {

    private ListView showOwnerItemList1;
    DatabaseReference databaseReferenceOwner,databaseReferenceOwnerdelete;

    private Button showAllButton1;
    private EditText ownerShowAll11;
    private TextView test1;
    private List<Item> itemlistowner;
    // private List<student> parentlist;
    private Arrayadapter customadapterowner;
    private ProgressBar progressbarShoeOwnerItem1;
    //private arrayadapter customadapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_owner_item);

       String ownershowname=MainActivity.User_ID;


        this.setTitle("Your House");



        AlertDialog.Builder alertdialogShowOwnerItem = new AlertDialog.Builder(this);
        alertdialogShowOwnerItem.setTitle("Hey...");
        alertdialogShowOwnerItem.setMessage("To delete a specified house\nPlease tap long on it !!! ");
        alertdialogShowOwnerItem.setPositiveButton("OK",null);
        AlertDialog alertDialogShowOwnerItem2 = alertdialogShowOwnerItem.create();
        alertDialogShowOwnerItem2.show();



        progressbarShoeOwnerItem1 = findViewById(R.id.progressbarShowOwnerId);
        progressbarShoeOwnerItem1.setVisibility(View.VISIBLE);

        //Toast.makeText(getApplicationContext(),ownershowname+"HIIII", Toast.LENGTH_SHORT).show();
        databaseReferenceOwner = FirebaseDatabase.getInstance().getReference("Owner").child(ownershowname);


        itemlistowner = new ArrayList<>();
        customadapterowner = new Arrayadapter(ShowOwnerItem.this,itemlistowner);
        showOwnerItemList1= findViewById(R.id.showOwnerItemList);

        showOwnerItemList1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item deleteItem = itemlistowner.get(i);
                String itemIDdelete =  deleteItem.getID();
               // Toast.makeText(getApplicationContext(),deleteItem.getOwnerName(),Toast.LENGTH_SHORT).show();
                databaseReferenceOwnerdelete=databaseReferenceOwner.child(itemIDdelete);
                deleteTheItem(databaseReferenceOwnerdelete);
                return false;
            }
        });

    }

    private void deleteTheItem(final DatabaseReference databaseReferenceOwnerdelete66) {
        AlertDialog.Builder confarmentiondelete = new AlertDialog.Builder(this);
        confarmentiondelete.setTitle("Delete !!!");
        confarmentiondelete.setMessage("Are you sure to delete it !!!");
        confarmentiondelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseReferenceOwnerdelete66.removeValue();
                Toast.makeText(getApplicationContext(),"Successfully remove it",Toast.LENGTH_SHORT).show();
            }
        });
        confarmentiondelete.setNegativeButton("No",null);
        AlertDialog deleteit = confarmentiondelete.create();
        deleteit.show();
    }


    @Override
    protected void onStart() {
        databaseReferenceOwner.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemlistowner.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Item item=dataSnapshot1.getValue(Item.class);
                    itemlistowner.add(item);
                }
                showOwnerItemList1.setAdapter(customadapterowner);

                progressbarShoeOwnerItem1.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}
