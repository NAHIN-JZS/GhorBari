/*This is the page to choose the user use as a RENTER or OWNER */


package com.example.ghorbari2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



    }
  /*  public void onclickmain(View view){
        if(view.getId() == R.id.renterbutton){
             //Toast.makeText(getApplicationContext(),"Get here ",Toast.LENGTH_SHORT).show();
            renter();

        }
        else if(view.getId() == R.id.ownerbutton){
            //Toast.makeText(getApplicationContext(),"Hreeeeeeeeee",Toast.LENGTH_SHORT).show();
            ownerfunction();
        }

    }

    private void ownerfunction() {
        Intent intent = new Intent(SignIn.this,ownerProfile.class);
        startActivity(intent);
       // Toast.makeText(getApplicationContext(),"Hreeeeeeeeee",Toast.LENGTH_SHORT).show();

    }

    private void renter() {
        //Toast.makeText(getApplicationContext(),"Get here ",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SignIn.this,renterProfile.class);
        startActivity(intent);
    }
*/

}
