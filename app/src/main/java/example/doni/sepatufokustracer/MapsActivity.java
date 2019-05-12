package example.doni.sepatufokustracer;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    DatabaseReference user;
    DatabaseReference lng;
    Marker marker;


    double Lat = -5.4413724;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ChildEventListener mChildEventListener;

        user = FirebaseDatabase.getInstance().getReference().child("user");
        lng = FirebaseDatabase.getInstance().getReference().child("longtitude");
        /*lat = FirebaseDatabase.getInstance().getReference().child("latitude");*/

        user.push().setValue(marker);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    /*@Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    user user1 = dataSnapshot1.getValue(user.class);

                    LatLng dejavu = new LatLng(user1.latitude, user1.longtitude);

                    mMap.addMarker(new MarkerOptions().position(dejavu).title("Bego!"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(dejavu));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }*/







    /*@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        lng.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Double coba = dataSnapshot.getValue(Double.class);
                LatLng sydney = new LatLng(Lat, Double.valueOf(coba));
                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                float zoomLevel = 16.0f;
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // Add a marker in Sydney and move the camera

    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Double Lat = Double.valueOf(dataSnapshot.child("latitude").getValue().toString());
                Double Lng = Double.valueOf(dataSnapshot.child("longtitude").getValue().toString());
                LatLng sydney = new LatLng(Lat, Lng);
                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                float zoomLevel = 16.0f;
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


}
