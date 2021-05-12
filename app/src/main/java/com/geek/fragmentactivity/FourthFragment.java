package com.geek.fragmentactivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FourthFragment extends Fragment {
    private Button button;
    private String value;

    public FourthFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        value = getArguments().getString("key2");
        Log.d("TAG", "onCreateView: " + value);
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.btn_next4);
        button.setOnClickListener(v -> {
            Fragment fragment = new FifthFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key3",value);
            fragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,fragment).addToBackStack(null).commit();
        });
    }
}