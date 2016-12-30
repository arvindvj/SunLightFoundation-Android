package com.example.varvind.congress;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import main_fragments.frag_bill;
import main_fragments.frag_com;
import main_fragments.frag_fav;
import main_fragments.frag_leg;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        frag_leg fragmenttab = new frag_leg();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_frame, fragmenttab).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager fm = getFragmentManager();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_legislator) {
            //toolbar.setTitle("Legislators");
            //fm.beginTransaction().replace(R.id.content_frame,new frag_leg()).commit();
            frag_leg fragmenttab = new frag_leg();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragmenttab).commit();

            // Handle the camera action
        } else if (id == R.id.nav_bill) {
            frag_bill fragmenttab = new frag_bill();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragmenttab).commit();
        } else if (id == R.id.nav_committee) {
            frag_com fragmenttab = new frag_com();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragmenttab).commit();
        } else if (id == R.id.nav_favourite) {
            frag_fav fragmenttab = new frag_fav();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragmenttab).commit();
        } else if (id == R.id.nav_about) {
            Intent info = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(info);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
