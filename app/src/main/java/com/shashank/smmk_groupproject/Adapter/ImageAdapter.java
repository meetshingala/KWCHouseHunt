package com.shashank.smmk_groupproject.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shashank.smmk_groupproject.R;
import com.shashank.smmk_groupproject.ui.Gallery.GalleryDialogFragment;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<String> imageUrlList;
    private Context context;

    public ImageAdapter(Context context, List<String> imageUrlList) {
        this.context = context;
        this.imageUrlList = imageUrlList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String imageUrl = imageUrlList.get(position);
        loadImageFromURL(imageUrl, holder.ivHouseImage);

        holder.ivHouseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the image in a dialog fragment
                FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
                GalleryDialogFragment dialog = new GalleryDialogFragment(imageUrlList, position);
                dialog.show(fm, "dialog_gallery");
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageUrlList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView ivHouseImage;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHouseImage = itemView.findViewById(R.id.iv_house_image);
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
