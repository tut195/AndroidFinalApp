package com.skillup.finalapp.data;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.skillup.finalapp.data.db.dao.LocationDao;
import com.skillup.finalapp.data.db.entity.Location;

@Database(entities = {Location.class}, version = 1)
public abstract class DaggerLocationDatabase extends RoomDatabase {

    public abstract LocationDao locationDao();
}
