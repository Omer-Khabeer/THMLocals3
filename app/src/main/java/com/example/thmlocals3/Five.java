package com.example.thmlocals3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Five extends AppCompatActivity implements View.OnClickListener{

    private TextView mib21, mib22, mib23, mib24, mib25;
    private String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        mib21 = findViewById(R.id.mib21);
        mib22 = findViewById(R.id.mib22);
        mib23 = findViewById(R.id.mib23);
        mib24 = findViewById(R.id.mib24);
        mib25= findViewById(R.id.mib25);

        mib21.setOnClickListener(this);
        mib22.setOnClickListener(this);
        mib23.setOnClickListener(this);
        mib24.setOnClickListener(this);
        mib25.setOnClickListener(this);

    }
    @Override
    public void onClick (View v){
        Intent i;

        switch (v.getId()) {
            case R.id.mib21:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB21");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib22:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB22");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib23:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB23");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib24:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB24");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib25:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB25");
                i.putExtra("userId", userId);
                startActivity(i);
                break;
        }
    }
}