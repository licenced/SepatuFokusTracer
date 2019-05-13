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

public class Longlat extends AppCompatActivity {

    DatabaseReference ambil;
    TextView longitude, latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longlat);
        ChildEventListener mChildEventListener;

        longitude = (TextView) findViewById(R.id.longitude_value);
        latitude = (TextView) findViewById(R.id.latitude_value);

        ambil = FirebaseDatabase.getInstance().getReference().child("user");


    }

    @Override
    protected void onStart() {
        super.onStart();

        ambil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Double lng = dataSnapshot.child("longtitude").getValue(Double.class);
                Double lat = dataSnapshot.child("latitude").getValue(Double.class);

                longitude.setText(String.valueOf(lng));
                latitude.setText(String.valueOf(lat));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
