package com.example.thmlocals3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Six extends AppCompatActivity implements View.OnClickListener{

    private TextView bachelorArbeit, praxisPhase;
    private String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        bachelorArbeit = findViewById(R.id.bachelorArbeit);
        praxisPhase = findViewById(R.id.praxisPhase);


        bachelorArbeit.setOnClickListener(this);
        praxisPhase.setOnClickListener(this);


    }
    @Override
    public void onClick (View v){
        Intent i;

        switch (v.getId()) {
            case R.id.bachelorArbeit:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "Bachelorarbeit");
                i.putExtra("userId", userId);
                startActivity(i);
                break;

            case R.id.praxisPhase:
                i = new Intent(this, Chat_Room.class);
                i.putExtra("mGroupName", "PraxisPhase");
                i.putExtra("userId", userId);
                startActivity(i);
                break;


        }
    }
}