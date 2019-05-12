package example.doni.sepatufokustracer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.view.Menu;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void keMap(View view) {
        Intent pindah = new Intent(this, MapsActivity.class);
        startActivity(pindah);
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

    public void keProfil(View view) {
    }

    public void keAboutUs(View view) {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_settings){

            Intent mIntent = new Intent(this, setting.class);

            startActivity(mIntent);

            Toast.makeText(this, "Buka Halaman Settings", Toast.LENGTH_SHORT).show();


            return  true;
        }


        return super.onOptionsItemSelected(item);
    }
}
