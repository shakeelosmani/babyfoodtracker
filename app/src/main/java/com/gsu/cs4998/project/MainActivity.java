package com.gsu.cs4998.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gsu.cs4998.project.database.DatabaseHelper;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private TextView today;
    private ImageView mImageView;
    private DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView)findViewById(R.id.imageView2);

        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        String imagePath = mDatabaseHelper.getChildPic();
        if(imagePath!=null){
            File f = new File(imagePath);
            Picasso.with(this).load(f).resize(84,148).placeholder(getResources().getDrawable(R.drawable.baby)).into(mImageView);
        }

        System.out.println(imagePath);

        mDrawerList = (ListView)findViewById(R.id.navList);mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");
        Date date = new Date();
        today = (TextView)findViewById(R.id.textView2);
        today.setText("Snapshot (" + dateFormat.format(date) + ")");

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    private void addDrawerItems() {
        String[] menuArray = { "Add baby", "Add Alarm", "Snapshot", "Exit" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(String.valueOf(position)=="0"){
                    Intent intent = new Intent(MainActivity.this,AddBaby.class);
                    startActivity(intent);
                }

                if(String.valueOf(position)=="1"){
                    Intent intent = new Intent(MainActivity.this,AddAlarm.class);
                    startActivity(intent);
                }

                if(String.valueOf(position)=="2"){
                    Intent intent = new Intent(MainActivity.this,Snapshot.class);
                    startActivity(intent);
                }
                if(String.valueOf(position)=="3"){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Are you sure you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    MainActivity.this.finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }


            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Baby Tracker Side-menu");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addAlarm(View view)
    {
        Intent intent = new Intent(this, AddAlarm.class);
        startActivity(intent);
    }

    public void addBaby(View view)
    {
        Intent intent = new Intent(this, AddBaby.class);
        startActivity(intent);
    }

    public void alarm(View view)
    {
        Intent intent = new Intent(this, Alarm.class);
        startActivity(intent);
    }

    public void bath(View view)
    {
        Intent intent = new Intent(this, Bath.class);
        startActivity(intent);
    }

    public void diaper(View view)
    {
        Intent intent = new Intent(this, Diaper.class);
        startActivity(intent);
    }

    public void feed(View view)
    {
        Intent intent = new Intent(this, Feed.class);
        startActivity(intent);
    }

    public void medication(View view)
    {
        Intent intent = new Intent(this, Medication.class);
        startActivity(intent);
    }

    public void sleep(View view)
    {
        Intent intent = new Intent(this, Sleep.class);
        startActivity(intent);
    }


    public void today(View view)
    {
        Intent intent = new Intent(this,Snapshot.class);
        startActivity(intent);
    }

    public void theme(View view)
    {
        Intent intent = new Intent(this, Theme.class);
        startActivity(intent);
    }

}
