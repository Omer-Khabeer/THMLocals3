package com.example.thmlocals3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
import java.util.Set;

public class Dashboard extends AppCompatActivity {
   private Button mAddGroup;
   private EditText mGroupName;
   private ListView mListview;
   private ArrayAdapter<String> arrayAdapter;
   private ArrayList<String> list_of_Groups = new ArrayList<>();
   private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mGroupName = findViewById(R.id.GruppeName);
        mAddGroup = findViewById(R.id.addGroup);
        mListview = findViewById(R.id.groupsView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_of_Groups);
        mListview.setAdapter(arrayAdapter);

        mAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put(mGroupName.getText().toString(), "");
                root.updateChildren(map);
            }
        });

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Set<String> set = new HashSet<String>();
                Iterator i = snapshot.getChildren().iterator();

                while (i.hasNext()) {
                   set.add(((DataSnapshot)i.next()).getKey());
                }

                list_of_Groups.clear();
                list_of_Groups.addAll(set);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(getApplicationContext(), Chat_Room.class);
               intent.putExtra("mGroupName", ((TextView)view).getText().toString());
               //intent.putExtra("user_name", name);
               startActivity(intent);
           }
       });
    }
}

/*
// Get a database Reference
Private DatabaseReference mDatabase;
mDatabase = FirebaseDatabase.getInstance().getReference();

// Write Data
public class User {
       public String userName;
       public String email;

       public User() {
       // Default constructor required for calls to DataSnapshot.getValue(User.class)
       }

       public User(String userName, String email) {
           this.userName = userName;
           this.email = email;
       }
   }

   // Add new User
   public void writeNewUser(String userId, String name, String email) {
         User user = new User(name, email);

         mDatabase.child("users").child(userId).setValue(user);
   }

   // Update user
   mDatabase.child("users").child(userId).child("username").setValue(name);

   // Read Data

 */

/*

// To get users-id and store it into our database


userID = fAuth.getCurrentUser().getUid();
DocumentReference documentReference = fStore.collection("users").document(userID);
Map<String, Object> user = new HashMap<> ();
user.put("fName",fullName);
user.put("email", email);
documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
    public void onSuccess(Void void) {
      log.d(Tag, msg:"onSuccess: user Profile is created for: " + userID );
    }
})
 */