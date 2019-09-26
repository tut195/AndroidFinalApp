package com.skillup.finalapp.data.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.skillup.finalapp.FinalApplication;
import com.skillup.finalapp.data.db.dao.LocationDao;
import com.skillup.finalapp.data.db.entity.Location;

@Database(entities = {Location.class}, version = 1)
public abstract class LocationDatabase extends RoomDatabase {

    private static LocationDatabase INSTANCE;

    public static LocationDatabase getAppDatabase() {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(FinalApplication.getAppContext(), LocationDatabase.class, "skillup.db")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            //.allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public abstract LocationDao locationDao();


}
