package com.shivam.irsc_isafe.Notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shivam.irsc_isafe.R;

import java.util.ArrayList;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        final ArrayList<NotificationClass> notifications=new ArrayList<>();

        final FirebaseDatabase databasenotification = FirebaseDatabase.getInstance();
        final DatabaseReference myRefnotification = databasenotification.getReference("Notifications");
        final RecyclerView li=findViewById(R.id.Notifylistview);


NotificationClass notify=new NotificationClass("hello","30/06/2018");
        myRefnotification.push().setValue(notify);


        //READ NOTIFICATION ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        myRefnotification.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot snap:dataSnapshot.getChildren()){
                   notifications.add(snap.getValue(NotificationClass.class));
                }
                NotificationAdaptor adapter=new NotificationAdaptor(Notifications.this,notifications);
                li.setLayoutManager(new LinearLayoutManager(Notifications.this));
                li.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }
}
