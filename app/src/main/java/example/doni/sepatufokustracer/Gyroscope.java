package example.doni.sepatufokustracer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Gyroscope extends AppCompatActivity {

    DatabaseReference user;
    DatabaseReference lng;
    DatabaseReference lat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        user = FirebaseDatabase.getInstance().getReference().child("user");
        lng = FirebaseDatabase.getInstance().getReference().child("longtitude");
        lat = FirebaseDatabase.getInstance().getReference().child("latitude");
    }
}
