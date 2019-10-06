package com.skillup.finalapp.presentation.add.impl;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.skillup.finalapp.data.LocationRepository;
import com.skillup.finalapp.data.db.entity.Location;
import com.skillup.finalapp.presentation.add.IAddMarkerPresenter;
import com.skillup.finalapp.view.add.IAddMarkersView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

@InjectViewState
public class AddMarkerPresenter extends MvpPresenter<IAddMarkersView> implements IAddMarkerPresenter {

    // LocationRepository_
    private LocationRepository repository;
    private CompositeDisposable disposable = new CompositeDisposable();

    private Double mLng = 0.0;
    private Double mLat = 0.0;


    // Constructor

    @Inject
    public AddMarkerPresenter(LocationRepository repository) {
        this.repository = repository;
    }

    // Life


    @Override
    public void changeLat(Double lat) {
        mLat = lat;
    }

    @Override
    public void changeLng(Double lng) {
        mLng = lng;
    }

    @Override
    public void addLocation() {
        disposable.add(
                repository.insertLocation(new Location(mLng, mLat))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(() -> getViewState().showSuccessPopup()));
    }

    @Override
    public void onDestroy() {
        disposable.clear();
        super.onDestroy();
    }
}
