package com.example.ghorbari2.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ghorbari2.R;
import com.example.ghorbari2.SignIn;
import com.example.ghorbari2.ownerProfile;
import com.example.ghorbari2.renterProfile;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button ownerfrag,renterfrag;

        ownerfrag= root.findViewById(R.id.ownerbutton);
        ownerfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),ownerProfile.class));
            }
        });
        renterfrag= root.findViewById(R.id.renterbutton);
        renterfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),renterProfile.class));
            }
        });



        return root;
    }
}