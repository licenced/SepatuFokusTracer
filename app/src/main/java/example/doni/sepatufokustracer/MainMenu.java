package example.doni.sepatufokustracer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.view.Menu;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Intent.ACTION_VIEW;


public class MainMenu extends AppCompatActivity {

    DatabaseReference kondisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        kondisi = FirebaseDatabase.getInstance().getReference().child("Keadaan");

        kondisi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String x = dataSnapshot.getValue(String .class);
                if (x.equals("Jatuh")){
                    notif();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void keMap(View view) {
        Intent pindah = new Intent(this, MapsActivity.class);
        startActivity(pindah);
        notif();
    }

    public void keLongLat(View view) {
        Intent longlat = new Intent(this, Longlat.class);
        startActivity(longlat);
    }

    public void keUltrasonic(View view) {
        Intent ultra = new Intent(this, Ultrasonic.class);
        startActivity(ultra);
    }

    public void keGyroscope(View view) {
        Intent gyro = new Intent(this, Gyroscope.class);
        startActivity(gyro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_settings) {

            Intent mIntent = new Intent(this, setting.class);

            startActivity(mIntent);

            Toast.makeText(this, "Buka Halaman Settings", Toast.LENGTH_SHORT).show();

            return true;
        } else if (item.getItemId()==R.id.logout){
                startActivity(new Intent(this, Login.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





    public void notif() {
        Intent intent = new Intent();
        PendingIntent pIntent = PendingIntent.getActivity(MainMenu.this, 0, intent , 0 );
        Notification noti = new Notification.Builder(MainMenu.this)
                .setTicker("tiker title")
                .setContentTitle("Coba")
                .setContentText("kdapdkasdkaspodkosdk")
                .setSmallIcon(R.drawable.sepatu)
                .setContentIntent(pIntent).getNotification();

        noti.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0,noti);
    }
}
