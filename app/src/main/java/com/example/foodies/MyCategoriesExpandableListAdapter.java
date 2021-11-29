package com.example.foodies;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.foodies.*;

import androidx.collection.CircularArray;

import java.util.ArrayList;
import java.util.HashMap;

public class MyCategoriesExpandableListAdapter extends BaseExpandableListAdapter {

    public static ArrayList<ArrayList<HashMap<String, String>>> childItems;
    public static ArrayList<HashMap<String, String>> parentItems;
    //    private final ArrayList<HashMap<String, String>> childItems;
    private LayoutInflater inflater;
    private Activity activity;
    private HashMap<String, String> child;
    private int count = 0;
    private boolean isFromMyCategoriesFragment;

    public MyCategoriesExpandableListAdapter(Activity activity, ArrayList<HashMap<String, String>> parentItems,
                                             ArrayList<ArrayList<HashMap<String, String>>> childItems,boolean isFromMyCategoriesFragment) {

        this.parentItems = parentItems;
        this.childItems = childItems;
        this.activity = activity;
        this.isFromMyCategoriesFragment = isFromMyCategoriesFragment;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int groupPosition, childPosition;

        for(groupPosition = 0; groupPosition < parentItems.size(); groupPosition++){

            if(groupPosition == 0) {
                for(childPosition = 0; childPosition < childItems.get(0).size(); childPosition++){
                    if(childItems.get(groupPosition).get(childPosition).get(ConstantManager.Parameter.IS_CHECKED).equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE)){
                        FirstFragment.prefMaster.setPrice(childPosition + 1);
                    }
                }
            } else if (groupPosition == 1) {
                for (childPosition = 0; childPosition < childItems.get(1).size(); childPosition++){
                    switch (childPosition) {
                        case 0:
                            FirstFragment.prefMaster.setAsian(true);
                            break;
                        case 1:
                            FirstFragment.prefMaster.setCafe(true);
                            break;
                        case 2:
                            FirstFragment.prefMaster.setMexicanHispanic(true);
                            break;
                        case 3:
                            FirstFragment.prefMaster.setFastFood(true);
                            break;
                        case 4:
                            FirstFragment.prefMaster.setPizza(true);
                            break;
                        case 5:
                            FirstFragment.prefMaster.setItalian(true);
                            break;
                        case 6:
                            FirstFragment.prefMaster.setSandwiches(true);
                            break;
                        case 7:
                            FirstFragment.prefMaster.setBurgers(true);
                            break;
                        case 8:
                            FirstFragment.prefMaster.setDessert(true);
                            break;
                        case 9:
                            FirstFragment.prefMaster.setChickenWings(true);
                            break;
                        case 10:
                            FirstFragment.prefMaster.setAmerican(true);
                            break;
                        case 11:
                            FirstFragment.prefMaster.setBar(true);
                            break;
                        case 12:
                            FirstFragment.prefMaster.setForeign(true);
                            break;
                        case 13:
                            FirstFragment.prefMaster.setSeafood(true);
                            break;
                        case 14:
                            FirstFragment.prefMaster.setBakery(true);
                            break;
                        case 15:
                            FirstFragment.prefMaster.setOther(true);
                            break;
                        }
                    }
                }else if (groupPosition == 2) {
                    for(childPosition = 0; childPosition < childItems.get(2).size(); childPosition++){
                        if(childItems.get(groupPosition).get(childPosition).get(ConstantManager.Parameter.IS_CHECKED).equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE)){
                            FirstFragment.prefMaster.setDistance(childPosition);
                        }
                    }
                }
            }

    }

    @Override
    public int getGroupCount() {
        return parentItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return (childItems.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, final boolean b, View convertView, ViewGroup viewGroup) {
        final ViewHolderParent viewHolderParent;
        if (convertView == null) {

            if(isFromMyCategoriesFragment) {
                convertView = inflater.inflate(R.layout.list_group, null);
            }else {
                convertView = inflater.inflate(R.layout.group_choose_categories, null);
            }
            viewHolderParent = new ViewHolderParent();

            viewHolderParent.MainCategoryName = convertView.findViewById(R.id.MainCategoryName);
            convertView.setTag(viewHolderParent);
        } else {
            viewHolderParent = (ViewHolderParent) convertView.getTag();
        }

        ConstantManager.childItems = childItems;
        ConstantManager.parentItems = parentItems;

        viewHolderParent.MainCategoryName.setText(parentItems.get(groupPosition).get(ConstantManager.Parameter.CATEGORY_NAME));

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, final boolean b, View convertView, ViewGroup viewGroup) {

        final ViewHolderChild viewHolderChild;
        child = childItems.get(groupPosition).get(childPosition);


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            viewHolderChild = new ViewHolderChild();

            viewHolderChild.SubCategoryName = convertView.findViewById(R.id.SubCategoryName);
            viewHolderChild.cbSubCategory = convertView.findViewById(R.id.cbSubCategory);
            viewHolderChild.viewDivider = convertView.findViewById(R.id.viewDivider);
            convertView.setTag(viewHolderChild);
        } else {
            viewHolderChild = (ViewHolderChild) convertView.getTag();
        }

        if (childItems.get(groupPosition).get(childPosition).get(ConstantManager.Parameter.IS_CHECKED).equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE)) {
            viewHolderChild.cbSubCategory.setChecked(true);
            notifyDataSetChanged();


        } else {
            viewHolderChild.cbSubCategory.setChecked(false);
            notifyDataSetChanged();
        }

        viewHolderChild.SubCategoryName.setText(child.get(ConstantManager.Parameter.SUB_CATEGORY_NAME));
        viewHolderChild.cbSubCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewHolderChild.cbSubCategory.isChecked()) {
                    count = 0;
                    childItems.get(groupPosition).get(childPosition).put(ConstantManager.Parameter.IS_CHECKED, ConstantManager.CHECK_BOX_CHECKED_TRUE);

                    if(groupPosition == 0 || groupPosition == 2){
                        for(int i = 0; i < childItems.get(groupPosition).size(); i++){
                            if(i != childPosition){
                                childItems.get(groupPosition).get(i).put(ConstantManager.Parameter.IS_CHECKED, ConstantManager.CHECK_BOX_CHECKED_FALSE);
                                viewHolderChild.cbSubCategory.setChecked(false);

                            } else if(i == childPosition && groupPosition == 0){
                                FirstFragment.prefMaster.setPrice(i + 1);
                            }else if(i == childPosition && groupPosition == 2){
                                FirstFragment.prefMaster.setDistance(i);
                            }
                        }
                    } else if (groupPosition == 1){
                        switch (childPosition) {
                            case 0:
                                if(childItems.get(groupPosition).get(childPosition).get(ConstantManager.Parameter.IS_CHECKED).equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE)){
                                    FirstFragment.prefMaster.setAsian(true);
                                }
                                break;
                            case 1:
                                FirstFragment.prefMaster.setCafe(true);
                                break;
                            case 2:
                                FirstFragment.prefMaster.setMexicanHispanic(true);
                                break;
                            case 3:
                                FirstFragment.prefMaster.setFastFood(true);
                                break;
                            case 4:
                                FirstFragment.prefMaster.setPizza(true);
                                break;
                            case 5:
                                FirstFragment.prefMaster.setItalian(true);
                                break;
                            case 6:
                                FirstFragment.prefMaster.setSandwiches(true);
                                break;
                            case 7:
                                FirstFragment.prefMaster.setBurgers(true);
                                break;
                            case 8:
                                FirstFragment.prefMaster.setDessert(true);
                                break;
                            case 9:
                                FirstFragment.prefMaster.setChickenWings(true);
                                break;
                            case 10:
                                FirstFragment.prefMaster.setAmerican(true);
                                break;
                            case 11:
                                FirstFragment.prefMaster.setBar(true);
                                break;
                            case 12:
                                FirstFragment.prefMaster.setForeign(true);
                                break;
                            case 13:
                                FirstFragment.prefMaster.setSeafood(true);
                                break;
                            case 14:
                                FirstFragment.prefMaster.setBakery(true);
                                break;
                            case 15:
                                FirstFragment.prefMaster.setOther(true);
                                break;
                        }
                    }

                    Toast.makeText(activity.getApplicationContext(), viewHolderChild.SubCategoryName.getText(), Toast.LENGTH_SHORT).show();

                    notifyDataSetChanged();
                } else {
                    count = 0;
                    childItems.get(groupPosition).get(childPosition).put(ConstantManager.Parameter.IS_CHECKED, ConstantManager.CHECK_BOX_CHECKED_FALSE);

                    if(groupPosition == 0){
                        FirstFragment.prefMaster.setPrice(1);
                        childItems.get(0).get(0).put(ConstantManager.Parameter.IS_CHECKED, ConstantManager.CHECK_BOX_CHECKED_TRUE);
                        viewHolderChild.cbSubCategory.setChecked(true);
                    }
                    else if (groupPosition == 2){
                        FirstFragment.prefMaster.setDistance(0);
                        childItems.get(2).get(0).put(ConstantManager.Parameter.IS_CHECKED, ConstantManager.CHECK_BOX_CHECKED_TRUE);
                        viewHolderChild.cbSubCategory.setChecked(true);
                    }
                    else if (groupPosition == 1){

                        switch (childPosition) {
                            case 0:
                                FirstFragment.prefMaster.setAsian(false);
                                break;
                            case 1:
                                FirstFragment.prefMaster.setCafe(false);
                                break;
                            case 2:
                                FirstFragment.prefMaster.setMexicanHispanic(false);
                                break;
                            case 3:
                                FirstFragment.prefMaster.setFastFood(false);
                                break;
                            case 4:
                                FirstFragment.prefMaster.setPizza(false);
                                break;
                            case 5:
                                FirstFragment.prefMaster.setItalian(false);
                                break;
                            case 6:
                                FirstFragment.prefMaster.setSandwiches(false);
                                break;
                            case 7:
                                FirstFragment.prefMaster.setBurgers(false);
                                break;
                            case 8:
                                FirstFragment.prefMaster.setDessert(false);
                                break;
                            case 9:
                                FirstFragment.prefMaster.setChickenWings(false);
                                break;
                            case 10:
                                FirstFragment.prefMaster.setAmerican(false);
                                break;
                            case 11:
                                FirstFragment.prefMaster.setBar(false);
                                break;
                            case 12:
                                FirstFragment.prefMaster.setForeign(false);
                                break;
                            case 13:
                                FirstFragment.prefMaster.setSeafood(false);
                                break;
                            case 14:
                                FirstFragment.prefMaster.setBakery(false);
                                break;
                            case 15:
                                FirstFragment.prefMaster.setOther(false);
                                break;
                        }

                        for(int i = 0; i < childItems.get(1).size(); i++){
                            if(childItems.get(1).get(i).get(ConstantManager.Parameter.IS_CHECKED).equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE)){
                                count++;
                            }
                        }
                        if(count == 0){
                            childItems.get(1).get(childPosition).put(ConstantManager.Parameter.IS_CHECKED, ConstantManager.CHECK_BOX_CHECKED_TRUE);
                            viewHolderChild.cbSubCategory.setChecked(true);
                           switch (childPosition) {
                                case 0:
                                    FirstFragment.prefMaster.setAsian(true);
                                    break;
                                case 1:
                                    FirstFragment.prefMaster.setCafe(true);
                                    break;
                                case 2:
                                    FirstFragment.prefMaster.setMexicanHispanic(true);
                                    break;
                                case 3:
                                    FirstFragment.prefMaster.setFastFood(true);
                                    break;
                                case 4:
                                    FirstFragment.prefMaster.setPizza(true);
                                    break;
                                case 5:
                                    FirstFragment.prefMaster.setItalian(true);
                                    break;
                                case 6:
                                    FirstFragment.prefMaster.setSandwiches(true);
                                    break;
                                case 7:
                                    FirstFragment.prefMaster.setBurgers(true);
                                    break;
                                case 8:
                                    FirstFragment.prefMaster.setDessert(true);
                                    break;
                                case 9:
                                    FirstFragment.prefMaster.setChickenWings(true);
                                    break;
                                case 10:
                                    FirstFragment.prefMaster.setAmerican(true);
                                    break;
                                case 11:
                                    FirstFragment.prefMaster.setBar(true);
                                    break;
                                case 12:
                                    FirstFragment.prefMaster.setForeign(true);
                                    break;
                                case 13:
                                    FirstFragment.prefMaster.setSeafood(true);
                                    break;
                                case 14:
                                    FirstFragment.prefMaster.setBakery(true);
                                    break;
                                case 15:
                                    FirstFragment.prefMaster.setOther(true);
                                    break;
                            }

                        }
                    }



                    Toast.makeText(activity.getApplicationContext(), viewHolderChild.SubCategoryName.getText(), Toast.LENGTH_SHORT).show();

                    notifyDataSetChanged();
                }

                ConstantManager.childItems = childItems;
                ConstantManager.parentItems = parentItems;
            }
        });

        return convertView;
    }

    public void changPrefMaster(int groupPosition, int childPosition){


    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    private class ViewHolderParent {

        TextView MainCategoryName;
    }

    private class ViewHolderChild {

        TextView SubCategoryName;
        CheckBox cbSubCategory;
        View viewDivider;
    }


}
