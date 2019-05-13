package example.doni.sepatufokustracer;


import android.content.Intent;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragment {


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.halaman_setting);
        settingPref();
    }

    private void settingPref() {

        Preference aboutPref = findPreference(getString(R.string.key_about));

        aboutPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference preference) {

                Toast.makeText(getActivity(), "Membuka Halaman About", Toast.LENGTH_SHORT).show();

                Intent about = new Intent(getActivity(), about.class);
                startActivity(about);

                return true;
            }
        });
    }
}
