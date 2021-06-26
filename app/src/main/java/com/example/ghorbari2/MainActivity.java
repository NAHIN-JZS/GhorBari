package com.example.ghorbari2;



        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText signInemail;
    private EditText signInpass;
    //private Button signInbutton;
    //private TextView register;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    private FirebaseUser firebaseUser;
    public static String User_ID="nahin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In");
        //Toast.makeText(getApplicationContext(),"Get here ",Toast.LENGTH_SHORT).show();
        signInemail=findViewById(R.id.signinemail);
        signInpass = findViewById(R.id.signinpass);
        //signInbutton=findViewById(R.id.signin);
        //  register=findViewById(R.id.toregister);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.signinprogress);

    }
    public void onclicksignIn(View view){

        switch (view.getId())
        {
            case R.id.signin:
                userlogin();

                break;
            case R.id.toregister:
                Intent intent = new Intent(this,signUp.class);
                startActivity(intent);

                break;
        }
    }

    private void userlogin() {
        final String email = signInemail.getText().toString().trim();
        String password = signInpass.getText().toString().trim();


        if(email.isEmpty())
        {
            signInemail.setError("Enter an email address");
            signInemail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signInemail.setError("Enter a valid email address");
            signInemail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signInpass.setError("Enter a password");
            signInpass.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            signInpass.setError("Enter atleast 6 charecter");
            signInpass.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    finish();


                    ////////////////////////////////get the current user////////////////////
                    firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                    User_ID = firebaseUser.getUid();


                    /////////////////////////taking finish///////////////////////
                    Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this,nev_all.class);


                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"unsecessful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
