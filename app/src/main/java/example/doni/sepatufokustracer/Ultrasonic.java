package example.doni.sepatufokustracer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ultrasonic extends AppCompatActivity {

    DatabaseReference Sumbu;
    TextView jarak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultrasonic);
        ChildEventListener mChildEventListener;


        jarak = (TextView) findViewById(R.id.jarak_value);
        Sumbu = FirebaseDatabase.getInstance().getReference().child("Jarak_lurus");


    }

    @Override
    protected void onStart() {
        super.onStart();

        Sumbu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String x = dataSnapshot.getValue(String.class);

                jarak.setText(String.valueOf(x));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
