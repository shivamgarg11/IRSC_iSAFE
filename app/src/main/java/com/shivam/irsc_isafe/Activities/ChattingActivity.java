package com.shivam.irsc_isafe.Activities;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shivam.irsc_isafe.Classes.messageclass;
import com.shivam.irsc_isafe.CreateActivity.Create_Activity;
import com.shivam.irsc_isafe.Notifications.Notifications;
import com.shivam.irsc_isafe.R;

import java.util.ArrayList;

public class ChattingActivity extends AppCompatActivity {

    final ArrayList<messageclass> chats=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        Intent i=new Intent(ChattingActivity.this,Create_Activity.class);
        startActivity(i);
        finish();



/*

        final FirebaseDatabase databasechatting = FirebaseDatabase.getInstance();
        final DatabaseReference myRefchatting = databasechatting.getReference("message").child(Login.userlogin.getTeamcode());
        final RecyclerView li=findViewById(R.id.listview);

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
               //writing message


        ImageView btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit=findViewById(R.id.Edittext);
                String str=edit.getText().toString();
                messageclass message1=new messageclass(str,"user1");
                myRefchatting.push().setValue(message1);
                edit.setText("");
            }
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
               // Reading message


        myRefchatting.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                chats.clear();
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot snap:dataSnapshot.getChildren()){
                   chats.add(snap.getValue(messageclass.class));
                    }
                chattingAdaptor adapter=new chattingAdaptor(ChattingActivity.this,chats,Login.userlogin.getContactnumber());
                li.setLayoutManager(new LinearLayoutManager(ChattingActivity.this));
                li.setAdapter(adapter);
                li.scrollToPosition(chats.size()-1);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

    }
}
