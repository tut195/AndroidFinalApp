package com.skillup.finalapp.view.main;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.skillup.finalapp.R;
import com.skillup.finalapp.view.main.adapter.MyPagerAdapter;
import com.skillup.finalapp.view.map.MapFragment;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector, Updatetable {

    MyPagerAdapter adapter;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager =  findViewById(R.id.vpPager);
        viewPager.setAdapter(adapter);


    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void notifyMapFragment() {
        adapter.notifyMapFragment();

        getSupportFragmentManager();
        Log.d("TAGAAA","dddddd");

    }
}
