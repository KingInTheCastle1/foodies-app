package com.example.foodies;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

import android.widget.AdapterView;
import android.widget.ExpandableListView;
import com.example.foodies.Model.*;
import android.util.Log;
import android.widget.Toast;

import com.example.foodies.databinding.FragmentPreferencesBinding;

public class PreferencesFragment extends Fragment {
    private FragmentPreferencesBinding binding;

    private ExpandableListView lvCategory;

    private ArrayList<DataItem> arCategory;
    private ArrayList<SubCategoryItem> arSubCategory;
    private ArrayList<ArrayList<SubCategoryItem>> arSubCategoryFinal;

    private ArrayList<HashMap<String, String>> parentItems;
    private ArrayList<ArrayList<HashMap<String, String>>> childItems;
    private MyCategoriesExpandableListAdapter myCategoriesExpandableListAdapter;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPreferencesBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){

            setupFilters();
    }

    private void setupFilters() {

            lvCategory = getView().findViewById(R.id.lvExp);
            arCategory = new ArrayList<>();
            arSubCategory = new ArrayList<>();
            parentItems = new ArrayList<>();
            childItems = new ArrayList<>();

            DataItem dataItem = new DataItem("1", "Price");

            SubCategoryItem price1 = new SubCategoryItem("1", "$");
            price1.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem price2 = new SubCategoryItem("2", "$$");
            price2.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);

            SubCategoryItem price3 = new SubCategoryItem("3", "$$$");
            price3.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);

            SubCategoryItem price4 = new SubCategoryItem("4", "$$$$");
            price4.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);

            arSubCategory.add(price1);
            arSubCategory.add(price2);
            arSubCategory.add(price3);
            arSubCategory.add(price4);

            dataItem.setSubCategory(arSubCategory);
            arCategory.add(dataItem);

            dataItem = new DataItem("2", "Genre");

            SubCategoryItem genre1 = new SubCategoryItem("1", "Asian");
            genre1.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre2 = new SubCategoryItem("2", "Cafe");
            genre2.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre3 = new SubCategoryItem("3", "Mexican/Hispanic");
            genre3.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre4 = new SubCategoryItem("4", "Fast Food");
            genre4.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre5 = new SubCategoryItem("5", "Pizza");
            genre5.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre6 = new SubCategoryItem("6", "Italian");
            genre6.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre7 = new SubCategoryItem("7", "Sandwiches");
            genre7.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre8 = new SubCategoryItem("8", "Burgers");
            genre8.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre9 = new SubCategoryItem("9", "Dessert");
            genre9.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre10 = new SubCategoryItem("10", "Chicken/Wings");
            genre10.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre11 = new SubCategoryItem("11", "American");
            genre11.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre12 = new SubCategoryItem("12", "Bar");
            genre12.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre13 = new SubCategoryItem("13", "Foreign");
            genre13.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre14 = new SubCategoryItem("14", "Seafood");
            genre14.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre15 = new SubCategoryItem("15", "Bakery");
            genre15.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            SubCategoryItem genre16 = new SubCategoryItem("16", "Other");
            genre16.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);


            arSubCategory = new ArrayList<>();
            arSubCategory.add(genre1);
            arSubCategory.add(genre2);
            arSubCategory.add(genre3);
            arSubCategory.add(genre4);
            arSubCategory.add(genre5);
            arSubCategory.add(genre6);
            arSubCategory.add(genre7);
            arSubCategory.add(genre8);
            arSubCategory.add(genre9);
            arSubCategory.add(genre10);
            arSubCategory.add(genre11);
            arSubCategory.add(genre12);
            arSubCategory.add(genre13);
            arSubCategory.add(genre14);
            arSubCategory.add(genre15);
            arSubCategory.add(genre16);

            dataItem.setSubCategory(arSubCategory);
            arCategory.add(dataItem);


            dataItem = new DataItem("3", "Distance");

            SubCategoryItem dist1 = new SubCategoryItem("1", "0 miles");
            dist1.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);

            SubCategoryItem dist2 = new SubCategoryItem("2", "≤ 1 mile");
            dist2.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);

            SubCategoryItem dist3 = new SubCategoryItem("3", "≤ 2 miles");
            dist3.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);

            arSubCategory = new ArrayList<>();
            arSubCategory.add(dist1);
            arSubCategory.add(dist2);
            arSubCategory.add(dist3);

            dataItem.setSubCategory(arSubCategory);
            arCategory.add(dataItem);

            Log.d("TAG", "setupReferences: " + arCategory.size());

            for (DataItem data : arCategory) {
//                        Log.i("Item id",item.id);
                ArrayList<HashMap<String, String>> childArrayList = new ArrayList<HashMap<String, String>>();
                HashMap<String, String> mapParent = new HashMap<String, String>();

                mapParent.put(ConstantManager.Parameter.CATEGORY_ID, data.getCategoryId());
                mapParent.put(ConstantManager.Parameter.CATEGORY_NAME, data.getCategoryName());

                int countIsChecked = 0;
                for (SubCategoryItem subCategoryItem : data.getSubCategory()) {

                    HashMap<String, String> mapChild = new HashMap<String, String>();
                    mapChild.put(ConstantManager.Parameter.SUB_ID, subCategoryItem.getSubId());
                    mapChild.put(ConstantManager.Parameter.SUB_CATEGORY_NAME, subCategoryItem.getSubCategoryName());
                    mapChild.put(ConstantManager.Parameter.CATEGORY_ID, subCategoryItem.getCategoryId());
                    mapChild.put(ConstantManager.Parameter.IS_CHECKED, subCategoryItem.getIsChecked());

                    if (subCategoryItem.getIsChecked().equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE)) {

                        countIsChecked++;
                    }
                    childArrayList.add(mapChild);
                }

                mapParent.put(ConstantManager.Parameter.IS_CHECKED, data.getIsChecked());
                childItems.add(childArrayList);
                parentItems.add(mapParent);

            }

            if(ConstantManager.parentItems.isEmpty() && ConstantManager.childItems.isEmpty()) {
                ConstantManager.parentItems = parentItems;
                ConstantManager.childItems = childItems;
            }else{
                parentItems = ConstantManager.parentItems;
                childItems = ConstantManager.childItems;
            }
            myCategoriesExpandableListAdapter = new MyCategoriesExpandableListAdapter(getActivity(),
                    parentItems, childItems, false);
            lvCategory.setAdapter(myCategoriesExpandableListAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}