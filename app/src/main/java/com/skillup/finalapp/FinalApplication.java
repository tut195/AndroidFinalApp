package com.skillup.finalapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.skillup.finalapp.di.DaggerAppComponent;
import com.skillup.finalapp.di.module.AppModule;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;


public class FinalApplication extends Application implements HasActivityInjector {

  private static Context context;

  @Inject
  DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
  String a;

  @Override
  public void onCreate() {
    super.onCreate();
    context = getApplicationContext();

    DaggerAppComponent.builder()
        .application(this)
        .appModule(new AppModule(this))
        .words("Hello world")
        .build()
        .inject(this);
  }


  public static Context getAppContext() {
    return FinalApplication.context;
  }

  @Override
  public AndroidInjector<Activity> activityInjector() {
    return dispatchingAndroidInjector;
  }

  public String getString() {
    return a;
  }
}
