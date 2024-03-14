package com.shashank.smmk_groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.shashank.smmk_groupproject.Adapter.ImageAdapter;
import com.shashank.smmk_groupproject.Model.House;

public class DetailedActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private House house;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        // Get the House object from the intent
        house = getIntent().getParcelableExtra("house");

        // Initialize the map fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);

        // Set up the RecyclerView for the house images
        RecyclerView recyclerView = findViewById(R.id.image_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new ImageAdapter(this, house.getImageUrls()));

        // Populate the TextViews with the house data
        // Populate the TextViews with the house data
        TextView tvAddress = findViewById(R.id.address_text);
        TextView tvPrice = findViewById(R.id.price_text);
        TextView tvBedrooms = findViewById(R.id.bedrooms_text);
        TextView tvBathrooms = findViewById(R.id.bathrooms_text);
        TextView tvPropertyType = findViewById(R.id.property_type_text);
        TextView tvSquareFootage = findViewById(R.id.square_footage_text);
        TextView tvLotSize = findViewById(R.id.lot_size_text);
        TextView tvYearBuilt = findViewById(R.id.year_built_text);
        TextView tvDescription = findViewById(R.id.description_text);


        tvAddress.setText(house.getAddress());
        tvPrice.setText("Price: $" + house.getPrice());
        tvBedrooms.setText("Bedrooms: " + house.getBedrooms());
        tvBathrooms.setText("Bathrooms: " + house.getBathrooms());
        tvPropertyType.setText("Property Type: " + house.getPropertyType());
        tvSquareFootage.setText("Square Footage: " + house.getSquareFootage() + " sq ft");
        tvLotSize.setText("Lot Size: " + house.getLotSize() + " acres");
        tvYearBuilt.setText("Year Built: " + house.getYearBuilt());
        tvDescription.setText(house.getDescription());
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style));
        // Add a marker for the house location and move the camera
        LatLng location = new LatLng(house.getLatitude(), house.getLongitude());
        mMap.addMarker(new MarkerOptions().position(location).title(house.getAddress()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //get home up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return super.onCreateOptionsMenu(menu);
    }
}
