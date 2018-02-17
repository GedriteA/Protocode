package com.thesis.protocode.main;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.thesis.protocode.OnlineCompiler.Online;
import com.thesis.protocode.R;
import com.thesis.protocode.about.aboutFragment;
import com.thesis.protocode.codeit.Compiler.codeit;
import com.thesis.protocode.database.DBHelper;
import com.thesis.protocode.dictionary.DataDictionary;
import com.thesis.protocode.dictionary.dictionaryFragment;
import com.thesis.protocode.drills.DBDrill;
import com.thesis.protocode.drills.drill.drillList;
import com.thesis.protocode.home.home;
import com.thesis.protocode.lessons.lessonFragment;
import com.thesis.protocode.samplecodes.Listsample;

public class nav_drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Cursor cursor;
    DataDictionary cursorData;
    DBDrill drill;
    TextView title;
    String id="PROTO";
    String name="CODE";
    static int check=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        String sourceString = id+"<b>"+name+"</b>" ;
        title=(TextView)header.findViewById(R.id.txtTitle);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Ubuntu-R.ttf");
        title.setText(Html.fromHtml(sourceString));
        title.setTypeface(font);

        FragmentManager fragmentManager = getSupportFragmentManager();
        home mhome=new home();
        fragmentManager.beginTransaction().replace(R.id.frame,mhome).commit();
        DBHelper db=new DBHelper(this);
        DBDrill drill=new DBDrill(this);
        DataDictionary dictionary=new DataDictionary(this);
        //Lesson
        db.addLesson1();
        db.addLesson();
        db.addLesson3();
        db.addLesson4();
        db.addLesson5();
        db.addLesson6();
        //Dictioanary
        cursorData = new DataDictionary(this);
        cursor=cursorData.getDictionaryList();
        if(cursor==null){
            dictionary.addDictionay();
        }
        //Drills
        drill.addQuestion();





        //






     }



    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
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

    


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        if (id == R.id.nav_home) {
            fragment = new home();
            check=1;
//
        } else if (id == R.id.nav_lessons)
        {
            // Create new fragment and transaction
            fragment= new lessonFragment();
            check=1;
//
        } else if (id == R.id.nav_codeit) {
           if(isNetworkAvailable()) {
               fragment = new codeit();
               check=1;

           }
           else
           {
            Toast.makeText(this,"Please connect to the Internet", Toast.LENGTH_SHORT).show();
               check=0;
           }
//
        } else if (id == R.id.nav_dictionay) {
            fragment =new dictionaryFragment();
            check=1;
//
        } else if (id == R.id.nav_sample) {
            fragment=new Listsample();
            check=1;

        } else if (id == R.id.nav_about) {
            fragment= new aboutFragment();
            check=1;
//
        }
        else if (id == R.id.nav_drills) {
            fragment= new drillList();
            check=1;
//
        }
        clearBackStack();
        if(check==1) {
            fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();

        }
        check=1;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }


    private void clearBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }


}
