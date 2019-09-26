package com.skillup.finalapp.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.skillup.finalapp.data.db.entity.Location;

import java.util.List;

import io.reactivex.Single;


@Dao
public interface LocationDao {
    @Query("SELECT * FROM location")
    Single<List<Location>> getAll();

    @Query("SELECT * FROM location WHERE id = :id")
    Single<Location> getById(long id);

    @Insert
    void insert(Location location);

    @Update
    void update(Location location);

    @Delete
    void delete(Location location);
}
