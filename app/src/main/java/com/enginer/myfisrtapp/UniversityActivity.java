package com.enginer.myfisrtapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UniversityActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_university, container, false);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng uadb = new LatLng(14.6959151,-16.4805438);
        mMap.addMarker(new MarkerOptions().position(uadb).title("UADB").snippet("Contact: 339733084, Site: uadb.edu.sn"));

        LatLng ucad = new LatLng(14.6903724,-17.4663296);
        mMap.addMarker(new MarkerOptions().position(ucad).title("UCAD").snippet("Contact: 338250530, Site: ucad.sn"));

        LatLng ugb = new LatLng(16.0626425,-16.4280584);
        mMap.addMarker(new MarkerOptions().position(ugb).title("UGB").snippet("Contact: 339619895, Site: ugb.sn"));

        LatLng uasz = new LatLng(12.5641531,-16.2661766);
        mMap.addMarker(new MarkerOptions().position(uasz).title("UASZ").snippet("Contact: 339916809, Site: uasz.sn"));

        CircleOptions co=  new CircleOptions()
                .center(uadb)
                .radius(500)
                .fillColor(Color.GREEN)
                .strokeColor(Color.BLUE)
                .strokeWidth(5);
        mMap.addCircle(co);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uadb, 12));
    }
}