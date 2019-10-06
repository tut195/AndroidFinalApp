package com.skillup.finalapp.di.module;

import com.skillup.finalapp.di.scopes.FragmentScope;
import com.skillup.finalapp.view.add.impl.AddFragment;
import com.skillup.finalapp.view.map.MapFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentModule {

  @ContributesAndroidInjector
  abstract MapFragment contributeMapFragment();

  @FragmentScope
  @ContributesAndroidInjector
  abstract AddFragment contributeAddFragment();
}
