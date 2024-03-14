package com.shashank.smmk_groupproject.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shashank.smmk_groupproject.MainActivity;
import com.shashank.smmk_groupproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IntroFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
// IntroFragment3.java
public class IntroFragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro3, container, false);

        Button proceedButton = view.findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish();
        });

        return view;
    }
}
