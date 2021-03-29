package com.example.thmlocals3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Nachhilfe extends AppCompatActivity implements View.OnClickListener{

    private TextView mSemester1, mSemester2, mSemester3, mSemester4, mSemester5, mSemester6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nachhilfe);

        mSemester1 =  findViewById(R.id.semester1);
        mSemester2 =  findViewById(R.id.semester2);
        mSemester3 =  findViewById(R.id.semester3);
        mSemester4 =  findViewById(R.id.semester4);
        mSemester5 =  findViewById(R.id.semester5);
        mSemester6 =  findViewById(R.id.semester6);

        mSemester1.setOnClickListener(this);
        mSemester2.setOnClickListener(this);
        mSemester3.setOnClickListener(this);
        mSemester4.setOnClickListener(this);
        mSemester5.setOnClickListener(this);
        mSemester6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.semester1:
                i = new Intent(this, One.class);
                startActivity(i);
                break;

            case R.id.semester2:
                i = new Intent(this, Two.class);
                startActivity(i);
                break;

            case R.id.semester3:
                i = new Intent(this, Three.class);
                startActivity(i);
                break;

            case R.id.semester4:
                i = new Intent(this, Four.class);
                startActivity(i);
                break;

            case R.id.semester5:
                i = new Intent(this, Five.class);
                startActivity(i);
                break;

            case R.id.semester6:
                i = new Intent(this, Six.class);
                startActivity(i);
                break;
        }
    }
}
