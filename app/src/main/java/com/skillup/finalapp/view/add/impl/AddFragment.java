package com.skillup.finalapp.view.add.impl;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.skillup.finalapp.R;
import com.skillup.finalapp.presentation.add.impl.AddMarkerPresenter;
import com.skillup.finalapp.view.add.IAddMarkersView;

public class AddFragment extends MvpAppCompatFragment implements IAddMarkersView {

    public static final String TITLE = "Coordinate";

    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        return fragment;
    }


    @InjectPresenter
    AddMarkerPresenter moxyPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText lat = view.findViewById(R.id.etLat);
        EditText lng = view.findViewById(R.id.etLng);

        lat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                moxyPresenter.changeLat(Double.valueOf(charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        lng.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                moxyPresenter.changeLng(Double.valueOf(charSequence.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        view.findViewById(R.id.btAdd).setOnClickListener(button -> moxyPresenter.addLocation());
    }

    @Override
    public void showSuccessPopup() {

    }
}
