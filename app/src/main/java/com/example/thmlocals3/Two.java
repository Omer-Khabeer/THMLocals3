package com.example.thmlocals3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Two extends AppCompatActivity implements View.OnClickListener{
    private TextView mib6, mib7, mib8, mib9, mib10;
    private String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        mib6 = findViewById(R.id.mib6);
        mib7 = findViewById(R.id.mib7);
        mib8 = findViewById(R.id.mib8);
        mib9 = findViewById(R.id.mib9);
        mib10 = findViewById(R.id.mib10);

        mib6.setOnClickListener(this);
        mib7.setOnClickListener(this);
        mib8.setOnClickListener(this);
        mib9.setOnClickListener(this);
        mib10.setOnClickListener(this);

    }
    @Override
    public void onClick (View v){
        Intent i;

        switch (v.getId()) {
            case R.id.mib6:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB6");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib7:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB7");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib8:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB8");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib9:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB9");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib10:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB10");
                i.putExtra("userId", userId);
                startActivity(i);
                break;
        }
    }
}