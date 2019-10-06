package com.skillup.finalapp.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.skillup.finalapp.di.ViewModelFactory;
import com.skillup.finalapp.presentation.map.MapViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

  @Binds
  abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);


  @Binds
  @IntoMap
  @ViewModelKey(MapViewModel.class)
  protected abstract ViewModel mapViewModel(MapViewModel mapViewModel);

}
