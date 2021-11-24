package com.example.foodies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.example.foodies.databinding.FragmentPreferencesBinding;

public class PreferencesFragment extends Fragment {
    private FragmentPreferencesBinding binding;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPreferencesBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        expListView =  getView().findViewById(R.id.lvExp);

        prepareListData();

        listAdapter = new ExpandableListAdapter(this.getContext(), listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);



    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Price");
        listDataHeader.add("Genre");
        listDataHeader.add("Distance");

        List<String> price = new ArrayList<String>();
        price.add("$");
        price.add("$$");
        price.add("$$$");
        price.add("$$$$");

        List<String> genre = new ArrayList<String>();
        genre.add("Asian");
        genre.add("Cafe");
        genre.add("Mexican/Hispanic");
        genre.add("Fast Food");
        genre.add("Pizza");
        genre.add("Italian");
        genre.add("Sandwiches");
        genre.add("Burgers");
        genre.add("Dessert");
        genre.add("Chicken/Wings");
        genre.add("American");
        genre.add("Bar");
        genre.add("Foreign");
        genre.add("Seafood");
        genre.add("Bakery");
        genre.add("Other");

        List<String> distance = new ArrayList<String>();
        distance.add("   0");
        distance.add("≤ 1 mile");
        distance.add("≤ 2 miles");

        listDataChild.put(listDataHeader.get(0), price);
        listDataChild.put(listDataHeader.get(1), genre);
        listDataChild.put(listDataHeader.get(2), distance);
    }


}