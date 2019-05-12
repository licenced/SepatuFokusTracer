package example.doni.sepatufokustracer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.pusher.pushnotifications.PushNotifications;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView lokasi, testt;
    DatabaseReference Lokasi;
    DatabaseReference Test;
    String a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PushNotifications.start(getApplicationContext(), "4f7546b0-b2d7-49a4-a12e-cc5990c97f0f");
        PushNotifications.subscribe("hello");

        lokasi = (TextView) findViewById(R.id.lokasiFirebase);
        Lokasi = FirebaseDatabase.getInstance().getReference().child("Lokasi");
        testt = (TextView) findViewById(R.id.TestFirebase);
        Test = FirebaseDatabase.getInstance().getReference().child("longtitude");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Lokasi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String kondisi = dataSnapshot.getValue(String.class);
                lokasi.setText(String.valueOf(kondisi));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Test.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double coba = dataSnapshot.getValue(Double.class);
                testt.setText(String.valueOf(coba));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void keMap(View view) {
        Intent pindah = new Intent(this, MapsActivity.class);
        startActivity(pindah);
    }
}
