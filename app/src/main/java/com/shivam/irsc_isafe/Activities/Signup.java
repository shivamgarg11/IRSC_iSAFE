package com.shivam.irsc_isafe.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shivam.irsc_isafe.Classes.users;
import com.shivam.irsc_isafe.R;

import java.util.Random;

public class Signup extends AppCompatActivity {

    EditText name,city,college,email,phone,password,repassword,teamcode;
    String strname,strcity,strcollege,stremail,strphone,strpassword,strrepassword,strteamcode,strsignas;
    Button submit,teamleader,teammember;
    LinearLayout linearlayoutdetails,linearLayoutbtn;

    RadioGroup r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        linearlayoutdetails=findViewById(R.id.linearlayoutdetails);
        linearLayoutbtn=findViewById(R.id.linearlayoutbtn);

        name=findViewById(R.id.signupname);
        city=findViewById(R.id.signupcity);
        college=findViewById(R.id.signupcollege);
        email=findViewById(R.id.signupemail);
        phone=findViewById(R.id.signupphone);
        password=findViewById(R.id.signuppassword);
        repassword=findViewById(R.id.signuprepassword);
        teamcode=findViewById(R.id.signupteamcode);

        teamleader=findViewById(R.id.btnteamleader);
        teammember=findViewById(R.id.btnteammember);
        submit=findViewById(R.id.signupbtnsubmit);


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


     teamleader.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            linearLayoutbtn.setVisibility(View.GONE);
            linearlayoutdetails.setVisibility(View.VISIBLE);
            strsignas="TeamLeader";
         }
     });


     teammember.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             linearLayoutbtn.setVisibility(View.GONE);
             linearlayoutdetails.setVisibility(View.VISIBLE);
             strsignas="TeamMember";
             teamcode.setVisibility(View.VISIBLE);
         }
     });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strname=name.getText().toString();
                strcity=city.getText().toString();
                strcollege=college.getText().toString();
                stremail=email.getText().toString();
                strphone=phone.getText().toString();
                strpassword=password.getText().toString();
                strrepassword=repassword.getText().toString();

                if(teamcode.getVisibility()==View.GONE){
                    strteamcode=strphone;
                }else{
                    strteamcode=teamcode.getText().toString();
                }


                if(strrepassword.equals(strpassword)){

                    final FirebaseDatabase databasesignup = FirebaseDatabase.getInstance();
                    final DatabaseReference myRefsignup = databasesignup.getReference("Login").child(strphone);
                    users user=new users(strname,strpassword,strcity,strcollege,stremail,strphone,strteamcode);
                    myRefsignup.setValue(user);
                    Intent i=new Intent(Signup.this,Login.class);
                    startActivity(i);
                    finish();


                }else{
                    repassword.setText("");
                    password.setText("");
                }

            }
        });



    }
}
