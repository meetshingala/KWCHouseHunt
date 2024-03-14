package com.shashank.smmk_groupproject.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class House implements Parcelable {
    private long houseId;
    private String address;
    private double latitude;
    private double longitude;
    private int price;
    private int bedrooms;
    private int bathrooms;
    private String propertyType;
    private double squareFootage;
    private double lotSize;
    private int yearBuilt;
    private String description;
    private List<String> imageUrls;
    private String listingDate;

    public House() {
    }

    public House(long houseId, String address, double latitude, double longitude, int price, int bedrooms, int bathrooms, String propertyType, double squareFootage, double lotSize, int yearBuilt, String description, List<String> imageUrls, String listingDate) {
        this.houseId = houseId;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.propertyType = propertyType;
        this.squareFootage = squareFootage;
        this.lotSize = lotSize;
        this.yearBuilt = yearBuilt;
        this.description = description;
        this.imageUrls = imageUrls;
        this.listingDate = listingDate;
    }

    protected House(Parcel in) {
        houseId = in.readLong();
        address = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        price = in.readInt();
        bedrooms = in.readInt();
        bathrooms = in.readInt();
        propertyType = in.readString();
        squareFootage = in.readDouble();
        lotSize = in.readDouble();
        yearBuilt = in.readInt();
        description = in.readString();
        imageUrls = in.createStringArrayList();
        listingDate = in.readString();
    }

    public static final Creator<House> CREATOR = new Creator<House>() {
        @Override
        public House createFromParcel(Parcel in) {
            return new House(in);
        }

        @Override
        public House[] newArray(int size) {
            return new House[size];
        }
    };

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public double getLotSize() {
        return lotSize;
    }

    public void setLotSize(double lotSize) {
        this.lotSize = lotSize;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getListingDate() {
        return listingDate;
    }

    public void setListingDate(String listingDate) {
        this.listingDate = listingDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(houseId);
        parcel.writeString(address);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeInt(price);
        parcel.writeInt(bedrooms);
        parcel.writeInt(bathrooms);
        parcel.writeString(propertyType);
        parcel.writeDouble(squareFootage);
        parcel.writeDouble(lotSize);
        parcel.writeInt(yearBuilt);
        parcel.writeString(description);
        parcel.writeStringList(imageUrls);
        parcel.writeString(listingDate);
    }
}

