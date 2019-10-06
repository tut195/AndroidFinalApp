package com.skillup.finalapp.data;


import com.skillup.finalapp.data.db.dao.LocationDao;
import com.skillup.finalapp.data.db.entity.Location;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocationRepository {

    private LocationDao locationDao;

    @Inject
    public LocationRepository(LocationDao locationDao, String string) {
        this.locationDao = locationDao;
    }

    public Single<List<Location>> getAllLocactions() {
        return locationDao.getAll();
    }

    public Completable insertLocation(Location location) {
        return Completable.fromAction(() -> locationDao.insert(location)).observeOn(Schedulers.io());
    }
}
