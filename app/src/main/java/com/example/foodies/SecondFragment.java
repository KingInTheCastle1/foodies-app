package com.example.foodies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.foodies.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv1 = (TextView) getView().findViewById(R.id.textView8);

        dbData[] data = FirstFragment.myDBData;
        String s;
        dbData d = data[1];

        s = d.getRestName() + ", " + d.getTagline() + ", Price :" + d.getPrice() + ", Genre: " + d.getTypeArr() + ", Distance: " + d.getDistance();



        tv1.setText(s);


        /*binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });*/


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}