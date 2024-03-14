package com.shashank.smmk_groupproject.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.shashank.smmk_groupproject.Model.House;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "houses.db";
    private static final int DATABASE_VERSION = 1;

    Context context;
    public HouseDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_HOUSES_TABLE = "CREATE TABLE houses (" +
                "house_id INTEGER PRIMARY KEY," +
                "address TEXT NOT NULL," +
                "latitude REAL," +
                "longitude REAL," +
                "price REAL," +
                "bedrooms INTEGER," +
                "bathrooms REAL," +
                "property_type TEXT," +
                "square_footage REAL," +
                "lot_size REAL," +
                "year_built INTEGER," +
                "description TEXT," +
                "image_urls TEXT," + // Store image URLs as a JSON array string
                "listing_date TEXT" + // Store date as a string (e.g., "2023-04-12")
                ");";

        db.execSQL(CREATE_HOUSES_TABLE);
        //
        db.execSQL("INSERT INTO houses (address, latitude, longitude, price, bedrooms, bathrooms, property_type, square_footage, lot_size, year_built, description, image_urls, listing_date) VALUES " +
                "('123 Elm St, Kitchener, ON, N2A 3G6', 43.453235, -80.494039, 599000, 3, 2.5, 'Detached', 2000, 0.25, 2010, 'A beautiful detached house in a quiet neighborhood.', '[\"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\"]', '2023-03-01');");
        db.execSQL("INSERT INTO houses (address, latitude, longitude, price, bedrooms, bathrooms, property_type, square_footage, lot_size, year_built, description, image_urls, listing_date) VALUES " +
                "('456 Oak Dr, Waterloo, ON, N2J 2S3', 43.476116, -80.536102, 750000, 4, 3, 'Detached', 2500, 0.3, 2008, 'Spacious detached house with a large backyard.', '[\"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\"]', '2023-03-05');");
        db.execSQL("INSERT INTO houses (address, latitude, longitude, price, bedrooms, bathrooms, property_type, square_footage, lot_size, year_built, description, image_urls, listing_date) VALUES " +
                "('789 Maple St, Cambridge, ON, N1S 4E2', 43.363292, -80.313844, 450000, 3, 1.5, 'Semi-Detached', 1500, 0.15, 1995, 'Cozy semi-detached house with recent updates.', '[\"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\"]', '2023-03-10');");
        db.execSQL("INSERT INTO houses (address, latitude, longitude, price, bedrooms, bathrooms, property_type, square_footage, lot_size, year_built, description, image_urls, listing_date) VALUES " +
                "('102 Pine Ave, Kitchener, ON, N2C 1A1', 43.421681, -80.456830, 650000, 4, 2.5, 'Detached', 2200, 0.2, 2012, 'Modern detached house with open-concept layout.', '[\"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\"]', '2023-03-15');");
        db.execSQL("INSERT INTO houses (address, latitude, longitude, price, bedrooms, bathrooms, property_type, square_footage, lot_size, year_built, description, image_urls, listing_date) VALUES " +
                "('305 Willow St, Waterloo, ON, N2K 4B4', 43.503886, -80.555129, 520000, 3, 2, 'Townhouse', 1800, 0.1, 2015, 'Well-maintained townhouse in a family-friendly community.', '[\"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\"]', '2023-03-20');");
        db.execSQL("INSERT INTO houses (address, latitude, longitude, price, bedrooms, bathrooms, property_type, square_footage, lot_size, year_built, description, image_urls, listing_date) VALUES " +
                "('608 Cedar Ave, Cambridge, ON, N3H 5M6', 43.398068, -80.334637, 480000, 3, 1.5, 'Semi-Detached', 1600, 0.12, 2000, 'Charming semi-detached house with a private backyard.', '[\"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\"]', '2023-03-25');");
        db.execSQL("INSERT INTO houses (address, latitude, longitude, price, bedrooms, bathrooms, property_type, square_footage, lot_size, year_built, description, image_urls, listing_date) VALUES " +
                "('711 Birch St, Kitchener, ON, N2A 2H7', 43.448745, -80.486437, 575000, 3, 2, 'Detached', 1900, 0.18, 2005, 'Comfortable detached house with a finished basement.', '[\"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\"]', '2023-03-30');");
        db.execSQL("INSERT INTO houses (address, latitude, longitude, price, bedrooms, bathrooms, property_type, square_footage, lot_size, year_built, description, image_urls, listing_date) VALUES " +
                "('814 Spruce Dr, Waterloo, ON, N2V 2K8', 43.510846, -80.575863, 700000, 4, 3, 'Detached', 2400, 0.25, 2010, 'Stunning detached house with a luxurious interior.', '[\"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\"]', '2023-04-04');");
        db.execSQL("INSERT INTO houses (address, latitude, longitude, price, bedrooms, bathrooms, property_type, square_footage, lot_size, year_built, description, image_urls, listing_date) VALUES " +
                "('917 Chestnut St, Cambridge, ON, N1R 6J1', 43.379821, -80.349254, 495000, 3, 1.5, 'Semi-Detached', 1700, 0.14, 1998, 'Attractive semi-detached house with a spacious layout.', '[\"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\", \"https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\"]', '2023-04-09');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS houses");
        onCreate(db);
    }

    @SuppressLint("Range")
    public List<House> getAllHouses() throws JSONException {
        List<House> houseList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM houses", null);

        if (cursor.moveToFirst()) {
            do {
                House house = new House();
                house.setHouseId(cursor.getInt(cursor.getColumnIndex("house_id")));
                house.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                house.setLatitude(cursor.getDouble(cursor.getColumnIndex("latitude")));
                house.setLongitude(cursor.getDouble(cursor.getColumnIndex("longitude")));
                house.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
                house.setBedrooms(cursor.getInt(cursor.getColumnIndex("bedrooms")));
                house.setBathrooms(cursor.getInt(cursor.getColumnIndex("bathrooms")));
                house.setPropertyType(cursor.getString(cursor.getColumnIndex("property_type")));
                house.setSquareFootage(cursor.getDouble(cursor.getColumnIndex("square_footage")));
                house.setLotSize(cursor.getDouble(cursor.getColumnIndex("lot_size")));
                house.setYearBuilt(cursor.getInt(cursor.getColumnIndex("year_built")));
                house.setDescription(cursor.getString(cursor.getColumnIndex("description")));
                String imageUrlString = cursor.getString(cursor.getColumnIndex("image_urls"));
                JSONArray jsonArray = new JSONArray(imageUrlString);
                List<String> imageUrls = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    String imageUrl = jsonArray.getString(i);
                    imageUrls.add(imageUrl);
                }
                house.setImageUrls(imageUrls);
                house.setListingDate(cursor.getString(cursor.getColumnIndex("listing_date")));
                houseList.add(house);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return houseList;
    }

    public void addHouse(House house) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", house.getAddress());
        contentValues.put("latitude", house.getLatitude());
        contentValues.put("longitude", house.getLongitude());
        contentValues.put("price", house.getPrice());
        contentValues.put("bedrooms", house.getBedrooms());
        contentValues.put("bathrooms", house.getBathrooms());
        contentValues.put("property_type", house.getPropertyType());
        contentValues.put("square_footage", house.getSquareFootage());
        contentValues.put("lot_size", house.getLotSize());
        contentValues.put("year_built", house.getYearBuilt());
        contentValues.put("description", house.getDescription());
        //
        contentValues.put("image_urls", "['https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2', 'https://images.pexels.com/photos/2816284/pexels-photo-2816284.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2', 'https://images.pexels.com/photos/1560065/pexels-photo-1560065.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2']");
        //
        contentValues.put("listing_date", house.getListingDate());
        //
        db.insert("houses", null, contentValues);
        Toast.makeText(context, "House Added", Toast.LENGTH_SHORT).show();
        //
        db.close();
    }





}
