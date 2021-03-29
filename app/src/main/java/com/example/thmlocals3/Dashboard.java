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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

import static com.google.firebase.auth.FirebaseAuth.getInstance;

public class Dashboard extends AppCompatActivity {
    private TextView mNachHilfe;
    private TextView mGruppen;
    private TextView mKennenlernen;
//   private Button mAddGroup;
//   private EditText mGroupName;
//   private ListView mListview;
//   private ArrayAdapter<String> arrayAdapter;
//   private ArrayList<String> list_of_Groups = new ArrayList<>();
//   private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();


   
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mNachHilfe = findViewById(R.id.NachhilfeKlasse);
        mGruppen = findViewById(R.id.GruppenKlasse);
        mKennenlernen = findViewById(R.id.KennenlernenKlasse);
       String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

       mNachHilfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Nachhilfe.class);
                startActivity(intent);
            }
        });

       mKennenlernen.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), Chat_Room.class);
               intent.putExtra("mGroupName", ((TextView)v).getText().toString());
               intent.putExtra("userId", userId);
               startActivity(intent);
           }
       });

       mGruppen.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), Gruppen.class);
               startActivity(intent);
           }
       });

//        mGroupName = findViewById(R.id.GruppeName);
//        mAddGroup = findViewById(R.id.addGroup);
//        mListview = findViewById(R.id.groupsView);
//        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_of_Groups);
//        mListview.setAdapter(arrayAdapter);


//

//        mAddGroup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put(mGroupName.getText().toString(), "");
//                root.updateChildren(map);
//            }
//        });

//        root.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Set<String> set = new HashSet<String>();
//                Iterator i = snapshot.getChildren().iterator();
//
//                while (i.hasNext()) {
//                   set.add(((DataSnapshot)i.next()).getKey());
//                }
//
//                list_of_Groups.clear();
//                list_of_Groups.addAll(set);
//                arrayAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//       mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//           @Override
//           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               Intent intent = new Intent(getApplicationContext(), Chat_Room.class);
//               intent.putExtra("mGroupName", ((TextView)view).getText().toString());
//               intent.putExtra("userId", userId);
//           startActivity(intent);
//           }
//       });
    }
}


// Dashbord class/Activity
// hier haben wir 3 Klassen, wo wir diese klassen => Nachhilfe, Gruppe, Kennenlernen aufrufen koennen

// Nachhilfe Klasse/Aktivititaet beinhaltet die Klasse Module wo wir dann die Module als ArrayListe haben (MIB1, MIB2, MIB3..)
// die Klasse Module ruft dann direkt die einzelnen Module auf, wo wir dann auf den entsprechenden Chat-Room landen
// Chat-Room ist selbst eine Klasse wo wir schreiben koennen.

// Gruppe Klasse beinhaltet dann die Gruppen, die von den einzelnen Users erstellt wurden :
// 1/ hier kann man auch die Gruppen beitreten und wird die Klasse Chat_room nochmal aufrufen => Schreiben koennen
// 2/ Man kann hier selbst Gruppen erstellen und wird direkt in DB hinzugefuegt

// Kennenlernen Klasse => hier wird einfach den Chat-Room klasse aufgerufen, man landet da und kann schreiben

