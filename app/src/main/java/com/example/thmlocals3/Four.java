package com.example.thmlocals3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Four extends AppCompatActivity implements View.OnClickListener{

    private TextView mib16, mib17, mib18, mib19, mib20;
    private String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        mib16 = findViewById(R.id.mib16);
        mib17 = findViewById(R.id.mib17);
        mib18 = findViewById(R.id.mib18);
        mib19 = findViewById(R.id.mib19);
        mib20 = findViewById(R.id.mib20);

        mib16.setOnClickListener(this);
        mib17.setOnClickListener(this);
        mib18.setOnClickListener(this);
        mib19.setOnClickListener(this);
        mib20.setOnClickListener(this);

    }
    @Override
    public void onClick (View v){
        Intent i;

        switch (v.getId()) {
            case R.id.mib16:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB16");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib17:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB17");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib18:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB18");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib19:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB19");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.mib20:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "MIB20");
                i.putExtra("userId", userId);
                startActivity(i);
                break;
        }
    }
}