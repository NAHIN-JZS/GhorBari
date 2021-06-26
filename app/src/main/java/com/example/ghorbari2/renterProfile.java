package com.example.ghorbari2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class renterProfile extends AppCompatActivity {


    private Spinner spinnerRenter1;
    String[] district1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renter_profile);

        /*****************Spinner***************/
        spinnerRenter1 = findViewById(R.id.spinnerRenter);
        district1 = getResources().getStringArray(R.array.district);
        ArrayAdapter<String> districtShow = new ArrayAdapter<String>(this,R.layout.renter_spinner_sample_view,R.id.renterSpinnerText,district1);
        spinnerRenter1.setAdapter(districtShow);
        //String ne = "Students";
        String value = spinnerRenter1.getSelectedItem().toString();

    }
       /**************end of spinner**************/
    private void showAllItem() {
        Intent intent = new Intent(renterProfile.this,showItemlist.class);
        String value = spinnerRenter1.getSelectedItem().toString();


        /****************passing district name**********************/
        Bundle bundle = new Bundle();
        bundle.putString("stuff",value);
        intent.putExtras(bundle);
        //passing that we are renter
        Bundle bundle1 = new Bundle();
        bundle1.putString("renter","Renter");
        intent.putExtras(bundle1);
        /*************end of passing***********************/
        startActivity(intent);
    }

    public void renterOnclick(View view) {
        showAllItem();
    }
}
