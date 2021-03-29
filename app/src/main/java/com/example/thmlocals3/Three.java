package com.example.thmlocals3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Three extends AppCompatActivity implements View.OnClickListener{

    private TextView mib11, mib12, mib13, mib14, mib15;
    private String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        mib11 = findViewById(R.id.mib11);
        mib12 = findViewById(R.id.mib12);
        mib13 = findViewById(R.id.mib13);
        mib14 = findViewById(R.id.mib14);
        mib15 = findViewById(R.id.mib15);

        mib11.setOnClickListener(this);
        mib12.setOnClickListener(this);
        mib13.setOnClickListener(this);
        mib14.setOnClickListener(this);
        mib15.setOnClickListener(this);

    }
    @Override
    public void onClick (View v){
        Intent i;

        switch (v.getId()) {
            case R.id.mib11:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB11");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib12:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB12");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib13:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB13");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib14:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB14");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib15:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB15");
                i.putExtra("userId", userId);
                startActivity(i);
                break;
        }
    }
}