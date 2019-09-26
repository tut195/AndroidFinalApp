package com.skillup.finalapp;

import android.app.Application;
import android.content.Context;


public class FinalApplication extends Application {

  private static Context context;

  @Override
  public void onCreate() {
    super.onCreate();
    context = getApplicationContext();

  }


  public static Context getAppContext() {
    return FinalApplication.context;
  }
}
