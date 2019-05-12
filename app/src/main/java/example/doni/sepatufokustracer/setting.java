package example.doni.sepatufokustracer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        getFragmentManager()
                .beginTransaction()
                .replace(R.id.setting_content, new SettingsFragment()).commit();

    }
}
