package com.ctech.chris.quarenfit;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initialize the bottom navigation */
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        initNavbar(bottomNav);
        // set home button to be enabled on startup
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    /* initializes functionality of navbar*/
    private void initNavbar(BottomNavigationView navBar) {
        // TODO improve readability
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                /* detect which button was pressed */
                Fragment selectedFrag = null;
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        selectedFrag = new HomeFragment();
                        break;
                    case R.id.nav_stats:
                        selectedFrag = new StatsFragment();
                        break;
                    case R.id.nav_exercise:
                        selectedFrag = new ExerciseFragment();
                        break;
                    default:
                        return false;
                }
                // display selected fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();
                return true;
            }
        });
    }

    // TODO: button to add new body stat or exercise
    public void onAddEntry(View view) {
        Toast.makeText(getApplicationContext(),"ADDING ENTRY", Toast.LENGTH_SHORT).show();
    }

    // TODO: button to update profile such as height, age, etc
    public void onUpdateProfile(View view) {
        Toast.makeText(getApplicationContext(), "UPDATING PROFILE", Toast.LENGTH_SHORT).show();
    }
}
