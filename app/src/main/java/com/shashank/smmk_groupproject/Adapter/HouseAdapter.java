package com.shashank.smmk_groupproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shashank.smmk_groupproject.DetailedActivity;
import com.shashank.smmk_groupproject.Model.House;
import com.shashank.smmk_groupproject.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.HouseViewHolder> {

    private List<House> houseList;
    private Context context;

    public HouseAdapter(Context context, List<House> houseList) {
        this.context = context;
        this.houseList = houseList;
    }

    @NonNull
    @Override
    public HouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.house_item, parent, false);
        return new HouseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HouseViewHolder holder, int position) {
        House house = houseList.get(position);
        holder.tvAddress.setText(house.getAddress());
        holder.tvPrice.setText(String.format("Price: $%,d", house.getPrice()));
        holder.tvLotSize.setText(String.format("Lot Size: %.2f acres", house.getLotSize()));

        // Assuming getImageUrls() returns a List<String>
        List<String> imageUrls = house.getImageUrls();
        if (!imageUrls.isEmpty()) {
            // Load the first image from the list
            loadImageFromURL(imageUrls.get(0), holder.ivHouseImage);
        }

        // Set click listener for the item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the DetailedActivity and pass the selected house object
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("house", house);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return houseList.size();
    }

    public class HouseViewHolder extends RecyclerView.ViewHolder {

        ImageView ivHouseImage;
        TextView tvAddress;
        TextView tvPrice;
        TextView tvLotSize;

        public HouseViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHouseImage = itemView.findViewById(R.id.iv_house_image);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvLotSize = itemView.findViewById(R.id.tv_lot_size);
        }
    }

    private void loadImageFromURL(final String imageUrl, final ImageView imageView) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(imageUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    final Bitmap myBitmap = BitmapFactory.decodeStream(input);

                    imageView.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(myBitmap);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}