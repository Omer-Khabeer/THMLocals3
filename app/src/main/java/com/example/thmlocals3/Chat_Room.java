package com.example.thmlocals3;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Chat_Room extends AppCompatActivity {
    private Button mBtnSend;
    private EditText mInputMsg;
    private TextView mChatConversation;
    private String mGroupName, user_name;
    private DatabaseReference root;
    private String temp_key;

    @Override
    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.chat_room);

        mBtnSend = findViewById(R.id.btn_send);
        mInputMsg = findViewById(R.id.inputMsg);
        mChatConversation = findViewById(R.id.textView);

        user_name = getIntent().getExtras().get("user_name").toString();
        mGroupName = getIntent().getExtras().get("mGroupName").toString();
        setTitle("Group: " + mGroupName);

        root = FirebaseDatabase.getInstance().getReference().child(mGroupName);

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map = new HashMap<String, Object>();
                temp_key = root.push().getKey();
                root.updateChildren(map);

                DatabaseReference message_root = root.child(temp_key);
                Map<String, Object> map2 = new HashMap<String, Object>();
                map2.put("name", user_name);
                map2.put("msg", mInputMsg.getText().toString());
                message_root.updateChildren(map2);
            }
        });

       root.addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
              append_child_conversation(snapshot);
           }

           @Override
           public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
               append_child_conversation(snapshot);
           }

           @Override
           public void onChildRemoved(@NonNull DataSnapshot snapshot) {

           }

           @Override
           public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
    }

    private void append_child_conversation(DataSnapshot snapshot) {
        Iterator i = snapshot.getChildren().iterator();

        while(i.hasNext()) {
//            chat_msg = (snapshot)i.next().getValue();
//            chat_user_name = (snapshot)i.next().getValue();
//
//            mChatConversation.append(chat_user_name + " : " + chat_msg + " \n");
        }
    }
}
