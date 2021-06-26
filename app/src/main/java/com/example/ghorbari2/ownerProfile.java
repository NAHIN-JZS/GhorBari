/*In this class we will show the owner's option */

package com.example.ghorbari2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ownerProfile extends AppCompatActivity {


    private  Button addhouse;
    private Button deletehouse;
    private Button showall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_profile);
        addhouse= findViewById(R.id.newhouse);
        showall = findViewById(R.id.showallhouse);

    }
    public void onclickowner (View view){

        if(view.getId() == R.id.showallhouse){

            ShowAllOwnerHouse();
        }
        else if(view.getId() == R.id.newhouse){
            addnewhouse();
        }


    }

    private void ShowAllOwnerHouse() {
            Intent intent = new Intent(this,ShowOwnerItem.class);
            startActivity(intent);

    }

    private void addnewhouse() {

        Intent intent = new Intent(this,AddHouse.class);
        startActivity(intent);
    }
}
