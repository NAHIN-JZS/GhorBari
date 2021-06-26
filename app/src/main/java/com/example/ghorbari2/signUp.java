package com.example.ghorbari2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class signUp extends AppCompatActivity {
    private EditText signUpemail;
    private EditText signUppass;
    private Button signup;
    private FirebaseAuth mAuth;
    private ProgressBar signupprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up");
        mAuth = FirebaseAuth.getInstance();
        signUpemail = findViewById(R.id.signupemail);
        signUppass = findViewById(R.id.signuppass);
        signup = findViewById(R.id.signup);
        signupprogress=findViewById(R.id.signupprogress);

    }
    public void onclicksignUp(View view){
        switch (view.getId()){
            case R.id.signup:
                userregister();
                break;
        }

    }

    private void userregister() {
        String email = signUpemail.getText().toString().trim();
        String password = signUppass.getText().toString().trim();


        if(email.isEmpty())
        {
            signUpemail.setError("Enter an email address");
            signUpemail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpemail.setError("Enter a valid email address");
            signUpemail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signUppass.setError("Enter a password");
            signUppass.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signUppass.setError("Enter atleast 6 charecter");
            signUppass.requestFocus();
            return;
        }
        signupprogress.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(signUp.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    signupprogress.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Registration is successful !",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signUp.this,SignIn.class);
                    startActivity(intent);
                } else {
                    // If sign in fails, display a message to the user.
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        signupprogress.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Already used this email id.",Toast.LENGTH_SHORT).show();
                    }

                    else{
                        signupprogress.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }

                // ...
            }
        });
    }
}
