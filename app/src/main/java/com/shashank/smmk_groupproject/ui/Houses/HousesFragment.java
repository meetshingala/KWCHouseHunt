package com.shashank.smmk_groupproject.ui.Houses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shashank.smmk_groupproject.Adapter.HouseAdapter;
import com.shashank.smmk_groupproject.DB.HouseDBHelper;
import com.shashank.smmk_groupproject.R;

import org.json.JSONException;

public class HousesFragment extends Fragment {

    public HousesFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private HouseAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_houses, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        HouseDBHelper dbHelper = new HouseDBHelper(getActivity());

        try {
            adapter = new HouseAdapter(getActivity(), dbHelper.getAllHouses());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        recyclerView.setAdapter(adapter);
        return view;
    }
}