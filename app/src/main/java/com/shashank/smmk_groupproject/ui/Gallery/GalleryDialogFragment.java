package com.shashank.smmk_groupproject.ui.Gallery;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.DialogFragment;
import androidx.viewpager2.widget.ViewPager2;

import com.shashank.smmk_groupproject.Adapter.GalleryPagerAdapter;
import com.shashank.smmk_groupproject.R;

import java.util.List;

public class GalleryDialogFragment extends DialogFragment {

    private List<String> imageUrls;
    private int position;

    public GalleryDialogFragment(List<String> imageUrls, int position) {
        this.imageUrls = imageUrls;
        this.position = position;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_gallery, container, false);

        ViewPager2 viewPager = view.findViewById(R.id.view_pager);
        ImageButton closeButton = view.findViewById(R.id.btn_close);

        GalleryPagerAdapter adapter = new GalleryPagerAdapter(getContext(), imageUrls);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position, false);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }

}

