package com.shashank.smmk_groupproject.ui.Houses;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.shashank.smmk_groupproject.DB.HouseDBHelper;
import com.shashank.smmk_groupproject.Model.House;
import com.shashank.smmk_groupproject.R;

import org.json.JSONException;

import java.util.List;

public class HousesMapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private HouseDBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbHelper = new HouseDBHelper(requireContext());
        return inflater.inflate(R.layout.fragment_houses_map, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        try {
            mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map_style));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }


        // Fetch house data from the database
        List<House> houses = null;
        try {
            houses = dbHelper.getAllHouses();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        // Add markers for the houses
        if (!houses.isEmpty()) {
            for (House house : houses) {
                LatLng position = new LatLng(house.getLatitude(), house.getLongitude());
                mMap.addMarker(new MarkerOptions().position(position).title(house.getAddress()));
            }

            // Move the camera to the first house
            House firstHouse = houses.get(0);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(firstHouse.getLatitude(), firstHouse.getLongitude()), 12f));
        }
    }
}
