package example.doni.sepatufokustracer;


import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

        CheckBoxPreference checkboxPref = (CheckBoxPreference) findPreference(getString(R.string.key_contoh_checkbox));

        SwitchPreference switchPref = (SwitchPreference) findPreference(getString(R.string.key_contoh_switch));

        aboutPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                Toast.makeText(getActivity(), "Membuka Halaman About", Toast.LENGTH_SHORT).show();

                return true;
            }
        });


        checkboxPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {


                if ((Boolean) newValue) {

                    Toast.makeText(getActivity(), "Checkbox Hidup", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getActivity(), "Checkbox Mati", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });

        switchPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {


                if ((Boolean) newValue) {

                    Toast.makeText(getActivity(), "Switch Hidup", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getActivity(), "Switch Mati", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });


    }

}
