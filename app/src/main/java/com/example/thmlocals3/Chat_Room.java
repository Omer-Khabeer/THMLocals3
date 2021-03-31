package com.example.thmlocals3;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Chat_Room extends AppCompatActivity {
    private Button mBtnSend;
    private EditText mInputMsg;
    private ListView mChatConversation;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> listOfMsg = new ArrayList<>();
    private String mGroupName, userId;
    private DatabaseReference root;
    private String temp_key;
    private String [] randomNames = {"Ameise","Adler","Aal","Alpaka","Axolotl","Biene","Bieber","Chinchilla","Dachs","Delfin","Erdmännchen","Eichhörnchen","Eule","Elch","Fuchs","Frosch","Falke","Giraffe","Gürteltier","Gecko","Hamster","Hai","Igel","Katze","Kakadu","Koala","Leopard","Luchs","Maus","Pferd","Rentier","Schwan","Tiger","Uhu","Zebra" };
    private String name;
    private ArrayList<String> idList  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.chat_room);

        mBtnSend = findViewById(R.id.btn_send);
        mInputMsg = findViewById(R.id.inputMsg);
//        mChatConversation = findViewById(R.id.textView);
        mChatConversation = findViewById(R.id.listOfMsg);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.mytextview2, listOfMsg);
        mChatConversation.setAdapter(arrayAdapter);

        userId = getIntent().getStringExtra("userId");
        mGroupName = getIntent().getStringExtra("mGroupName");
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
                map2.put("userId", userId);
                map2.put("msg", mInputMsg.getText().toString());
                message_root.updateChildren(map2);
                mInputMsg.setText("");
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

    private String getRandomName() {
        int min=0;
        int max=34;
        Random rand = new Random();
        int randomNum = rand.nextInt((max-min)+1)+min;
        String name = randomNames[randomNum];
        return name;
    }

private String chat_msg, chat_userId;
    private void append_child_conversation(DataSnapshot snapshot) {
        Set<String> set = new HashSet<String>();
        Iterator i = snapshot.getChildren().iterator();

        while(i.hasNext()) {
            chat_msg = (String) ((DataSnapshot) i.next()).getValue();
            chat_userId = (String) ((DataSnapshot)i.next()).getValue();
            if(!idList.contains(chat_userId)) {
                name=getRandomName();
            }
            idList.add(chat_userId);
            set.add(name + " : " + chat_msg + " \n\n");
        }

         listOfMsg.addAll(set);
         arrayAdapter.notifyDataSetChanged();
    }
}

