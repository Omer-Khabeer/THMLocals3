package com.example.thmlocals3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button mStart;

    // Declare FB
    private FirebaseAuth mAuth;
    private static final String TAG = "AnonymousAuth";

    // Declare FB Reference to be able to collect users ID
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize FB
        mAuth = FirebaseAuth.getInstance();
        // End initialize


        mStart = findViewById(R.id.start);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    onStart();
                    signInAnonymously();
            }
        });
    }

    // check to see if the user signed in
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {

       if(currentUser != null) {
           startActivity(new Intent(getApplicationContext(), Dashboard.class));
           finish();
           return;
       }
    }

    private void signInAnonymously() {

        mAuth.signInAnonymously()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            // Sign in success, update UI with the signed in user`s information

                            Log.d(TAG, "signInAnonymously:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // if sign in fails, display a msg to the user
//                            Log.w(TAG, "signInAnonymously:failure");
//                            Toast.makeText(AnonymousAuthActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }


                    }
                });
    }

    public void writeNewUser(String userId) {
        User user = new User(userId);
        mDatabase.child("users").child(userId).setValue(user);
    }


}


/*
private Button add_room;
private EditText room_name;
private ListView listView;

private ArrayAdapter<String> arrayAdapter;
private ArrayList<String> list_of_rooms = new ArrayList<>();
// access Database
private DataBaseReference root = Firebase.getInstance().getReference().getRoot();

// onCreate
add_room = (Button) findViewById(R.id.btn_add_room);
room_name = (EditText) findViewById(R.id.room_name_edittext);
listView = (ListView) findViewById(R.id.listView);
arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_of_rooms);

listView.setAdapter(arrayAdapter);

add_room.setOnClickListener(new View.onClickListener() {
    @Override
       public void onClick(View view) {
         // update the database with new rooms
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(room_name.getText().toString(), "");
        root.updateChildren(map);
        }
        });

        // Show this available rooms in the list view
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               // Go through the Database and read it, here only the first level of children, before we do that we have to make sure that we dont get dupliate rooms
               Set<String> set = new HashSet<String>();
               Iterator i = dataSnapshot.getChildren().iterator();

               // Then we use hasNext iterator which reads the database line by line
               while(i.hasNext){
                 set.add(((DataSnapshot)i.next()).getKey());
               }

               list_of_rooms.clear(); // clear the current list
               list_of_rooms.addAll(set); // append it using this method which contains all the rooms names
               arrayAdapter.notifyDataSetChanged(); // to update the UI
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 // new Intent to go to Chat_room
             Intent intent = new Intent(getApplicationContext(), Chat_Room.class);
             intent.putExtra("room_name", ((TextView)view).getText().toString() );
             intent.putExtra("user_name", name);
             startActivity(intent);
            }
            })
        })_
 */
