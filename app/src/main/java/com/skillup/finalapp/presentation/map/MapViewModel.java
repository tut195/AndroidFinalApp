package com.skillup.finalapp.presentation.map;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.maps.model.MarkerOptions;
import com.skillup.finalapp.data.LocationRepository;
import com.skillup.finalapp.data.db.entity.Location;
import com.skillup.finalapp.utils.LocationMaper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class MapViewModel extends ViewModel {


//    private LocationDatabase db = LocationDatabase.getAppDatabase();
//    private LocationDao locationDao = db.locationDao();
//    private CompositeDisposable disposable = new CompositeDisposable();

    private CompositeDisposable disposable = new CompositeDisposable();



    private LiveData<List<MarkerOptions>> mapMarkers;
    private MutableLiveData<List<MarkerOptions>> _mapMarkers = new MutableLiveData();

    @Inject
    public MapViewModel(LocationRepository locationRepository) {
//        Single<List<Location>> locations = locationDao.getAll();
        Single<List<Location>> locations = locationRepository.getAllLocactions();


        Disposable dis = locations
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Location>>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void accept(List<Location> locations) throws Exception {
                        List<MarkerOptions> markers = new ArrayList<>();

                        for (Location location : locations) {
                            markers.add(LocationMaper.map(location));
                        }
                        _mapMarkers.postValue(markers);
                    }
                });

        disposable.add(dis);

    }

    public LiveData<List<MarkerOptions>> getMapMarkers() {
        return _mapMarkers;
    }

    @Override
    protected void onCleared() {
        disposable.clear();
        super.onCleared();

    }
}
