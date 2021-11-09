package com.example.foodies;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodies.databinding.FragmentPreferencesBinding;

public class PreferencesFragment extends Fragment {
    private FragmentPreferencesBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPreferencesBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
}