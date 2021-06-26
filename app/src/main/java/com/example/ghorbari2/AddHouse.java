/*This class will add a new house*/


package com.example.ghorbari2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddHouse extends AppCompatActivity {
    private EditText roomnumberadd1;
    private EditText sizeadd1;
    private EditText addressadd1;
    private EditText owneradd1;
    private EditText descriptionadd1;
    private EditText phoneNumber1;
    private EditText rentFee1;
    private Spinner spinnerAdd1;

    ///////////////////////////////////////////////////////////////
    private String userAddHouse1;
    public static String uerAddHouse2="Nahin";

    //////////////////////////////////////////////////////////////////
    private Button addButtonAdd1;

    DatabaseReference databaseReference;
    DatabaseReference databaseReference11;

    String[] districtAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_house);
        //cityadd1 = findViewById(R.id.cityadd);
        roomnumberadd1 = findViewById(R.id.roomnumberadd);
        sizeadd1 = findViewById(R.id.sizeadd);
        addressadd1 = findViewById(R.id.addressadd);
        owneradd1 = findViewById(R.id.owneradd);
        descriptionadd1 = findViewById(R.id.descriptionadd);
        addButtonAdd1 = findViewById(R.id.addButtonAdd);
        rentFee1=findViewById(R.id.rentFeeAdd);
        phoneNumber1 = findViewById(R.id.phoneNumberAdd);

        //////////////////////////////////////
        //Intent intentAddHouse = getIntent();
        //userAddHouse1 = intentAddHouse.getStringExtra(ownerProfile.userownerProfile2);
        //////////////////////////////////////////////

        userAddHouse1=MainActivity.User_ID;


        spinnerAdd1 = findViewById(R.id.spinnerAdd);
        districtAdd = getResources().getStringArray(R.array.district);
        ArrayAdapter<String> districtShow = new ArrayAdapter<String>(this,R.layout.add_district_spinner,R.id.spinnerTextviewAdd,districtAdd);
        spinnerAdd1.setAdapter(districtShow);
        //String ne = "Students";
        String district1 = spinnerAdd1.getSelectedItem().toString().trim();


    }

    public void onclickadd(View view) {

        if( view.getId() == R.id.addButtonAdd){
            addNewHouse();
        }
    }

    private void addNewHouse() {

        String owner = owneradd1.getText().toString().trim();
        String district1 = spinnerAdd1.getSelectedItem().toString().trim();
        userAddHouse1=MainActivity.User_ID;
        //databaseReference = FirebaseDatabase.getInstance().getReference("Owner").child(owner);
       // Toast.makeText(getApplicationContext(),"User_Id :"+userAddHouse1,Toast.LENGTH_SHORT).show();
        databaseReference = FirebaseDatabase.getInstance().getReference("Owner").child(userAddHouse1);///////////////////new////////////////
        databaseReference11 = FirebaseDatabase.getInstance().getReference(district1);

        String key = databaseReference.push().getKey();
        String key11 = databaseReference11.push().getKey();
        String phoneNumber11 = phoneNumber1.getText().toString().trim();
        String rentFee11 = rentFee1.getText().toString().trim();
        String roomNo = roomnumberadd1.getText().toString().trim();
        String size = sizeadd1.getText().toString().trim();
        String address = addressadd1.getText().toString().trim();

        String description = descriptionadd1.getText().toString().trim();



        Item item = new Item(owner,district1,address,description,roomNo,size,rentFee11,phoneNumber11,key);
        databaseReference.child(key).setValue(item);
        databaseReference11.child(key11).setValue(item);
        databaseReference11.child(key).setValue(item);

        Toast.makeText(getApplicationContext(),"Successfully added", Toast.LENGTH_SHORT).show();
        //name.setText("");
        //age.setText("")
    }
}
