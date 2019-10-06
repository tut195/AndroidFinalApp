package com.skillup.finalapp.di;

import android.app.Application;
import com.skillup.finalapp.FinalApplication;
import com.skillup.finalapp.di.module.ActivityModule;
import com.skillup.finalapp.di.module.AppModule;
import com.skillup.finalapp.di.module.DatabaseModule;
import com.skillup.finalapp.di.module.FragmentModule;
import com.skillup.finalapp.di.module.ViewModelModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    //AppModule.class,
    ActivityModule.class,
    FragmentModule.class,
    DatabaseModule.class,
    ViewModelModule.class,
    AndroidInjectionModule.class,
    AndroidSupportInjectionModule.class})
public interface AppComponent {


  /* We will call this builder interface from our custom Application class.
   * This will set our application object to the AppComponent.
   * So inside the AppComponent the application instance is available.
   * So this application instance can be accessed by our modules
   * such as ApiModule when needed
   * */


  @Component.Builder
  interface Builder {

    @BindsInstance
    public Builder application(Application application);

    @BindsInstance
    Builder words(String aaa);

    @BindsInstance
    Builder appModule(AppModule appModule);

    AppComponent build();
  }


  /*
   * This is our custom Application class
   * */
  void inject(FinalApplication finalApplication);

}
