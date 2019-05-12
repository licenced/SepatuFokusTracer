package example.doni.sepatufokustracer;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class user {
    public double latitude;
    public double longtitude;

    public user() {

    }

    public user (double latitude, double longtitude){
        this.latitude = latitude;
        this.longtitude = longtitude;
    }
}
