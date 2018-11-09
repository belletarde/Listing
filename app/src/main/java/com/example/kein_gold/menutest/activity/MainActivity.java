package com.example.kein_gold.menutest.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kein_gold.menutest.R;
import com.example.kein_gold.menutest.adapter.SectionsPagerAdapter;
import com.example.kein_gold.menutest.fragment.Tab1;
import com.example.kein_gold.menutest.fragment.Tab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        initViewPager();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        navigationView.setCheckedItem(id);
        TabLayout tbLayout = findViewById(R.id.tab_layout_main);
        if (id == R.id.nav_camera) {
            TabLayout.Tab tab = tbLayout.getTabAt(0);
            if (tab != null) {
                tab.select();
            }
        } else if (id == R.id.nav_share) {
            TabLayout.Tab tab = tbLayout.getTabAt(1);
            if (tab != null) {
                tab.select();
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initViewPager() {
        TabLayout mTabLayout = findViewById(R.id.tab_layout_main);
        ViewPager mViewPager = findViewById(R.id.container);

        List<String> titles = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.tabs_names)));

        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Tab1());
        fragments.add(new Tab2());

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        if(fragments.size() > 4) {
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }

        mViewPager.setOffscreenPageLimit(1);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
