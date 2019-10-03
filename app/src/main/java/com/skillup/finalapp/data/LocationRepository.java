package com.skillup.finalapp.data;

import com.skillup.finalapp.data.db.dao.LocationDao;
import com.skillup.finalapp.data.db.entity.Location;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class LocationRepository {


    private LocationDao locationDao;


    public LocationRepository(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public Single<List<Location>> getAllLocactions() {
        return locationDao.getAll();
    }

    public Completable insertLocation(Location location) {
        return Completable.fromAction(() -> locationDao.insert(location)).observeOn(Schedulers.io());
    }

}
