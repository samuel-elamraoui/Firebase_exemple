package com.example.myapplicationfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="SMIN";
    private DatabaseReference myDataBase ;
    private EditText identifierEditText;
    private EditText nameEditText;
    private TextView informationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        identifierEditText = findViewById(R.id.identifier_input);
        nameEditText = findViewById(R.id.name_input);
        informationTextView= findViewById(R.id.personneInfo);


        myDataBase= FirebaseDatabase.getInstance().getReference();

    }

    public void submitNewPerson(View view) {
        String newIdentifier = identifierEditText.getText().toString();
        String newName = nameEditText.getText().toString();
        Personne newPerson = new Personne (newIdentifier,newName);
        myDataBase.child("personnes").child(newPerson.getIdentifier()).setValue(newPerson);
        myDataBase.child("personnes").child(newPerson.getIdentifier()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Personne updatePerson= snapshot.getValue(Personne.class);
                    informationTextView.setText(updatePerson.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}