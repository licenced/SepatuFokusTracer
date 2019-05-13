package example.doni.sepatufokustracer;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Gyroscope extends AppCompatActivity {

    DatabaseReference Sumbu;
    TextView sum_x,sum_y,sum_z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        ChildEventListener mChildEventListener;

        sum_x = (TextView) findViewById(R.id.sumbu_x);
        sum_y = (TextView) findViewById(R.id.sumbu_y);
        sum_z = (TextView) findViewById(R.id.sumbu_z);
        Sumbu = FirebaseDatabase.getInstance().getReference().child("gyroscope");


    }

    @Override
    protected void onStart() {
        super.onStart();

        Sumbu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String x = dataSnapshot.child("x").getValue(String.class);
                String y = dataSnapshot.child("y").getValue(String.class);
                String z = dataSnapshot.child("z").getValue(String.class);

                sum_x.setText(String.valueOf(x));
                sum_y.setText(String.valueOf(y));
                sum_z.setText(String.valueOf(z));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
