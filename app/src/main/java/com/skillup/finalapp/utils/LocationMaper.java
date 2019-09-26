package com.skillup.finalapp.utils;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.skillup.finalapp.data.db.entity.Location;

public class LocationMaper {

    public static MarkerOptions map(Location location) {
        return new MarkerOptions()
                .position(new LatLng(location.getLng(), location.getLat()));
    }
}
