package com.shivam.irsc_isafe.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shivam.irsc_isafe.Classes.users;
import com.shivam.irsc_isafe.R;

public class Login extends AppCompatActivity {

    public  static users userlogin;

    EditText username,password;
    Button login ,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.loginusername);
        password=findViewById(R.id.loginpassword);
        login=findViewById(R.id.btnlogin);
        signup=findViewById(R.id.btnsignup);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamestr=username.getText().toString();
                final String passwordstr=password.getText().toString();

                final FirebaseDatabase databaselogin = FirebaseDatabase.getInstance();
                final DatabaseReference myReflogin = databaselogin.getReference("Login").child(usernamestr);

                myReflogin.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        userlogin = dataSnapshot.getValue(users.class);
                        if(userlogin.getPassword().equals(passwordstr)){
                            Intent i=new Intent(Login.this,ChattingActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("TAG", "Failed to read value.", error.toException());
                    }
                });


            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Signup.class);
                startActivity(i);
                finish();
            }
        });
    }
}
