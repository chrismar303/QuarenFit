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

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        initNavbar(bottomNav);
    }

    private void initNavbar(BottomNavigationView navBar) {
        BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();
                return true;
            }
        };
//        navBar.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
//
//            }
//        });
    }

    public void onAddEntry(View view) {
        Toast.makeText(getApplicationContext(),"ADDING ENTRY", Toast.LENGTH_SHORT);
    }
}
