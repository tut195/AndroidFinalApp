package com.skillup.finalapp.di.module;

import android.app.Application;
import androidx.room.Room;
import com.skillup.finalapp.data.DaggerLocationDatabase;
import com.skillup.finalapp.data.db.dao.LocationDao;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class DatabaseModule {


  @Provides
  @Singleton
  DaggerLocationDatabase providesDaggerLocationDatabase(Application application) {
    return Room.databaseBuilder(application, DaggerLocationDatabase.class, "gaggerDatabase.db")
        //.allowMainThreadQueries()
        .build();
  }

  @Provides
  @Singleton
  LocationDao providesLocationDao(DaggerLocationDatabase daggerLocationDatabase) {
    return daggerLocationDatabase.locationDao();
  }
}
