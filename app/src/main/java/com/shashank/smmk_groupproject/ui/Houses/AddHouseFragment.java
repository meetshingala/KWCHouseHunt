package com.shashank.smmk_groupproject.ui.Houses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.shashank.smmk_groupproject.DB.HouseDBHelper;
import com.shashank.smmk_groupproject.Model.House;
import com.shashank.smmk_groupproject.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddHouseFragment extends Fragment {

    EditText latitudeEditText, longitudeEditText, addressEditText, priceEditText, descriptionEditText, bedroomsEditText, bathroomsEditText, propertyTypeEditText, squareFootageEditText, lotSizeEditText, yearBuiltEditText;

    public AddHouseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_house, container, false);
        //get all edit text
        latitudeEditText = view.findViewById(R.id.latitudeEditText);
        longitudeEditText = view.findViewById(R.id.longitudeEditText);
        addressEditText = view.findViewById(R.id.addressEditText);
        priceEditText = view.findViewById(R.id.priceEditText);
        descriptionEditText = view.findViewById(R.id.descriptionEditText);
        bedroomsEditText = view.findViewById(R.id.bedroomsEditText);
        bathroomsEditText = view.findViewById(R.id.bathroomsEditText);
        propertyTypeEditText = view.findViewById(R.id.propertyTypeEditText);
        lotSizeEditText = view.findViewById(R.id.lotSizeEditText);
        squareFootageEditText = view.findViewById(R.id.squareFootageEditText);
        yearBuiltEditText = view.findViewById(R.id.yearBuiltEditText);
        Button addButton = view.findViewById(R.id.addHouseButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveHouse();
            }
        });

        return view;
    }

    private void saveHouse() {
        if (!validateInput()) {
            return;
        }

        House house = new House();
        house.setAddress(addressEditText.getText().toString());
        house.setLatitude(Double.parseDouble(latitudeEditText.getText().toString()));
        house.setLongitude(Double.parseDouble(longitudeEditText.getText().toString()));
        house.setPrice(Integer.parseInt(priceEditText.getText().toString()));
        house.setBedrooms(Integer.parseInt(bedroomsEditText.getText().toString()));
        house.setBathrooms(Integer.parseInt(bathroomsEditText.getText().toString()));
        house.setPropertyType(propertyTypeEditText.getText().toString());
        house.setSquareFootage(Double.parseDouble(squareFootageEditText.getText().toString()));
        house.setLotSize(Double.parseDouble(lotSizeEditText.getText().toString()));
        house.setYearBuilt(Integer.parseInt(yearBuiltEditText.getText().toString()));
        house.setDescription(descriptionEditText.getText().toString());

        // Add image

        // Set the current date as the listing date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String currentDate = sdf.format(new Date());
        house.setListingDate(currentDate);

        HouseDBHelper dbHelper = new HouseDBHelper(requireContext());
        dbHelper.addHouse(house);
    }
    private boolean validateInput() {
        boolean isValid = true;

        if (latitudeEditText.getText().toString().isEmpty()) {
            latitudeEditText.setError("Latitude is required.");
            isValid = false;
        } else {
            try {
                Double.parseDouble(latitudeEditText.getText().toString());
            } catch (NumberFormatException e) {
                latitudeEditText.setError("Please enter a valid latitude.");
                isValid = false;
            }
        }

        if (longitudeEditText.getText().toString().isEmpty()) {
            longitudeEditText.setError("Longitude is required.");
            isValid = false;
        } else {
            try {
                Double.parseDouble(longitudeEditText.getText().toString());
            } catch (NumberFormatException e) {
                longitudeEditText.setError("Please enter a valid longitude.");
                isValid = false;
            }
        }

        if (addressEditText.getText().toString().isEmpty()) {
            addressEditText.setError("Address is required.");
            isValid = false;
        }

        if (priceEditText.getText().toString().isEmpty()) {
            priceEditText.setError("Price is required.");
            isValid = false;
        } else {
            try {
                Integer.parseInt(priceEditText.getText().toString());
            } catch (NumberFormatException e) {
                priceEditText.setError("Please enter a valid price.");
                isValid = false;
            }
        }

        if (descriptionEditText.getText().toString().isEmpty()) {
            descriptionEditText.setError("Description is required.");
            isValid = false;
        }

        if (bedroomsEditText.getText().toString().isEmpty()) {
            bedroomsEditText.setError("Bedrooms is required.");
            isValid = false;
        } else {
            try {
                Integer.parseInt(bedroomsEditText.getText().toString());
            } catch (NumberFormatException e) {
                bedroomsEditText.setError("Please enter a valid number of bedrooms.");
                isValid = false;
            }
        }

        if (bathroomsEditText.getText().toString().isEmpty()) {
            bathroomsEditText.setError("Bathrooms is required.");
            isValid = false;
        } else {
            try {
                Integer.parseInt(bathroomsEditText.getText().toString());
            } catch (NumberFormatException e) {
                bathroomsEditText.setError("Please enter a valid number of bathrooms.");
                isValid = false;
            }
        }

        if (propertyTypeEditText.getText().toString().isEmpty()) {
            propertyTypeEditText.setError("Property type is required.");
            isValid = false;
        }

        if (squareFootageEditText.getText().toString().isEmpty()) {
            squareFootageEditText.setError("Square footage is required.");
            isValid = false;
        } else {
            try {
                Double.parseDouble(squareFootageEditText.getText().toString());
            } catch (NumberFormatException e) {
                squareFootageEditText.setError("Please enter a valid square footage.");
                isValid = false;
            }
        }

        if (lotSizeEditText.getText().toString().isEmpty()) {
            lotSizeEditText.setError("Lot size is required.");
            isValid = false;
        } else {
            try {
                Double.parseDouble(lotSizeEditText.getText().toString());
            } catch (NumberFormatException e) {
                lotSizeEditText.setError("Please enter a valid lot size.");
                isValid = false;
            }
        }

        if (yearBuiltEditText.getText().toString().isEmpty()) {
            yearBuiltEditText.setError("Year built is required.");
            isValid = false;
        } else {
            try {
                Integer.parseInt(yearBuiltEditText.getText().toString());
            } catch (NumberFormatException e) {
                yearBuiltEditText.setError("Please enter a valid year built.");
                isValid = false;
            }
        }
        return isValid;
    }

}