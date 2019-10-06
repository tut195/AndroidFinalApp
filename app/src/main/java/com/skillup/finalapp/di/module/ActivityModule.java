package com.skillup.finalapp.di.module;


import com.skillup.finalapp.di.scopes.ActivityScope;
import com.skillup.finalapp.view.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityModule {


  @ActivityScope
  @ContributesAndroidInjector(modules = FragmentModule.class)
  abstract MainActivity contributeMainActivity();

}
