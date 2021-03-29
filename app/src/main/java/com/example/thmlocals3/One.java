package com.example.thmlocals3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class One extends AppCompatActivity implements View.OnClickListener {
    private TextView mib1, mib2, mib3, mib4, mib5;
    private String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        mib1 = findViewById(R.id.mib1);
        mib2 = findViewById(R.id.mib2);
        mib3 = findViewById(R.id.mib3);
        mib4 = findViewById(R.id.mib4);
        mib5 = findViewById(R.id.mib5);

        mib1.setOnClickListener(this);
        mib2.setOnClickListener(this);
        mib3.setOnClickListener(this);
        mib4.setOnClickListener(this);
        mib5.setOnClickListener(this);

    }
        @Override
        public void onClick (View v){
            Intent i;

            switch (v.getId()) {
                case R.id.mib1:
                    i = new Intent(this, Chat_Room.class);
                    i.putExtra("mGroupName", "MIB1");
                    i.putExtra("userId", userId);
                    startActivity(i);
                    break;

                case R.id.mib2:
                    i = new Intent(this, Chat_Room.class);
                    i.putExtra("mGroupName", "MIB2");
                    i.putExtra("userId", userId);
                    startActivity(i);
                    break;

                case R.id.mib3:
                    i = new Intent(this, Chat_Room.class);
                    i.putExtra("mGroupName", "MIB3");
                    i.putExtra("userId", userId);
                    startActivity(i);
                    break;

                case R.id.mib4:
                    i = new Intent(this, Chat_Room.class);
                    i.putExtra("mGroupName", "MIB4");
                    i.putExtra("userId", userId);
                    startActivity(i);
                    break;

                case R.id.mib5:
                    i = new Intent(this, Chat_Room.class);
                    i.putExtra("mGroupName", "MIB5");
                    i.putExtra("userId", userId);
                    startActivity(i);
                    break;
            }
        }
    }

