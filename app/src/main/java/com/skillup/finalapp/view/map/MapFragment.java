package com.skillup.finalapp.view.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.skillup.finalapp.R;
import com.skillup.finalapp.di.ViewModelFactory;
import com.skillup.finalapp.presentation.map.MapViewModel;
import dagger.android.support.AndroidSupportInjection;
import java.util.List;
import javax.inject.Inject;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    public static final String TITTLE = "MAP";
    private GoogleMap mMap;
    private Boolean isMapReady;

    @Inject
    ViewModelFactory factory;

    private MapViewModel viewModel;

    // Constructor

    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, factory).get(MapViewModel.class);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        isMapReady = true;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CameraPosition googlePlex = CameraPosition.builder()
                .target(new LatLng(37.4219999, -122.0862462))
                .zoom(20)
                .bearing(0)
                .tilt(0)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(37.4219999, -122.0862462))
                .title("This is Title")
        );

        viewModel.getMapMarkers().observe(this, new Observer<List<MarkerOptions>>() {
            @Override
            public void onChanged(List<MarkerOptions> markerOptions) {

                for (MarkerOptions markerOption : markerOptions) {
                    mMap.addMarker(markerOption);
                }


                if(markerOptions.size()>0){
                    MarkerOptions last = markerOptions.get(0);

                    CameraPosition googlePlex1 = CameraPosition.builder()
                        .target(last.getPosition())
                        .zoom(20)
                        .bearing(0)
                        .tilt(0)
                        .build();

                    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex1), 10000, null);
                }
            }

        });
    }

    public void notifyMy(){
        // todo use view model

    }
}