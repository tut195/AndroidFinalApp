package com.skillup.finalapp.view.add.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.skillup.finalapp.R;
import com.skillup.finalapp.presentation.add.impl.AddMarkerPresenter;
import com.skillup.finalapp.view.add.IAddMarkersView;
import com.skillup.finalapp.view.main.Updatetable;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;

public class AddFragment extends MvpAppCompatFragment implements IAddMarkersView {

    public static final String TITLE = "Coordinate";

    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        return fragment;
    }


    @Inject
    AddMarkerPresenter daggerPresenter;


    @InjectPresenter
    AddMarkerPresenter moxyPresenter;

    @ProvidePresenter
    AddMarkerPresenter providePresenter() {
        return daggerPresenter;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
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

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Double lat = parseDouble(editable.toString());

                moxyPresenter.changeLat(lat);
            }
        });

        lng.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
              Double lng = parseDouble(editable.toString());
              moxyPresenter.changeLng(lng);
            }
        });

        view.findViewById(R.id.btAdd).setOnClickListener(button -> moxyPresenter.addLocation());
    }

    @Override
    public void showSuccessPopup() {
        notifyMap();
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext())
            .setMessage("Coordinates are added");
        builder.show();


    }

    private void notifyMap(){
        FragmentActivity parentActivity =  requireActivity();
        if (parentActivity instanceof Updatetable){
            ((Updatetable) parentActivity).notifyMapFragment();
        }
    }

    private double parseDouble(String s){
        if(s == null || s.isEmpty())
            return 0.0;
        else
            return Double.parseDouble(s);
    }
}
